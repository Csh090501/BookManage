package org.action;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.model.Book;
import org.service.BookService;
import org.service.LendService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BookAction implements RequestAware, ModelDriven<Book>, Preparable{
	private int pageNow=1;   				 //初始页面为第一页
	private int pageSize=4;   				 //每页显示4天记录
		private String message;
		private File photo;
		private Book book=null;
		private BookService bookService=null;
		private LendService lendService=null;
		
		public void init(){
			ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		    bookService = (BookService) ctx.getBean("bookService");
		    lendService = (LendService) ctx.getBean("lendService");
		}	
		
		public String addBook() throws Exception{
			init();
			Book bo=bookService.selectBook(book.getISBN());
			if(bo!=null){              	 	//判断要添加的图书是否已经存在
				this.setMessage("ISBN已经存在！");
				return "success";
			}else{
//			Book b=new Book();
//			b.setISBN(book.getISBN());
//			b.setBookName(book.getBookName());
//			b.setAuthor(book.getAuthor());
//			b.setPublisher(book.getPublisher());
//			b.setPrice(book.getPrice());
//			b.setCnum(book.getCnum());
//			b.setSnum(book.getCnum());
//			b.setSummary(book.getSummary());
			if(this.getPhoto()!=null){
				FileInputStream fis=new FileInputStream(this.getPhoto());
				byte[] buffer=new byte[fis.available()];
				fis.read(buffer);
				book.setPhoto(buffer);
			}
			if(bookService.addBook(book)){
				this.setMessage("添加成功！");
				return "success";
			}else{
				this.setMessage("添加失败！");
				return "success";
			}	
		  }
		}
		
		public String deleteBook() throws Exception{
//			LendDao lendDao = new LendDao();
			init();
			Book bo=bookService.selectBook(book.getISBN());
			if(bo==null){             //首先判断是否存在该图书
				this.setMessage("要删除的图书不存在！");
				return "success";
			}else if(lendService.selectByBookISBN(book.getISBN())!=null){
				this.setMessage("该图书已经被借出,故不能删除图书信息！");
				return "success";
			}
			bookService.deleteBook(book);
			this.setMessage("删除成功！");
			return "success";
		}

		public String selectBook() throws Exception{
			init();
			Book onebook=bookService.selectBook(book.getISBN());
			if(onebook==null){
				this.setMessage("不存在该图书！");
				return "success";
			}
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("onebook", onebook);
			return "success";
		}

		public String getImage() throws Exception{
			init();
			HttpServletResponse response = ServletActionContext.getResponse();
			String ISBN=book.getISBN();
			Book b=bookService.selectBook(ISBN);
			byte[] photo = b.getPhoto();
			response.setContentType("image/jpg");
			ServletOutputStream os = response.getOutputStream();
			if ( photo != null && photo.length != 0 )
			{
				for (int i = 0; i < photo.length; i++)
				{
					os.write(photo[i]);
				}
				os.flush();
			}
			return "none";
		}

		public String updateBook() throws Exception{
			init();
			Book b=bookService.selectBook(book.getISBN());
			if(b==null){
				this.setMessage("要修改的图书不存在,请先查看是否存在该图书！");
				return "success";
			}
			b.setISBN(book.getISBN());
			b.setBookName(book.getBookName());
			b.setAuthor(book.getAuthor());
			b.setPublisher(book.getPublisher());
			b.setPrice(book.getPrice());
			b.setCnum(book.getCnum());
			b.setSnum(book.getSnum());
			b.setSummary(book.getSummary());
			if(this.getPhoto()!=null){
				FileInputStream fis=new FileInputStream(this.getPhoto());
				byte[] buffer=new byte[fis.available()];
				fis.read(buffer);
				b.setPhoto(buffer);
			}
			if(bookService.updateBook(b)){
				this.setMessage("修改成功！");
				return "success";
			}else{
				this.setMessage("修改失败！");
				return "success";
			}		
		}

		public String queryBook()throws Exception{
			init();
			if(book.getBookName()==null || book.getBookName().equals("")||
					bookService.queryBook1(book.getBookName())==null){
				setMessage("书名不能为空或者不存在该图书！");
				return "aaa";
			}
			List<Book> list=bookService.queryBook2(book.getBookName(),this.getPageSize(), this.getPageNow());
			Pager page=new Pager(pageNow,bookService.selectBookSize(book.getBookName()));
			Map request=(Map) ActionContext.getContext().get("request");		
			request.put("list", list);
			request.put("page", page);
			request.put("bookName", book.getBookName()); 
			return "aaa";
			}
		
		private String ISBN;
		
		public void setISBN(String ISBN) {
			this.ISBN = ISBN;
		}
		
		public String delete() throws Exception{
			
            if(lendService.selectByBookISBN(ISBN)!=null){
				this.setMessage("该图书已经被借出,故不能删除图书信息！");
				return "success";
			}
			if(bookService.deleteBook(book)){
				this.setMessage("删除成功！");
				return "success";
			}else{
				this.setMessage("删除失败！");
				return "success";
			}
			
		}
		
		public String edit(){
			System.out.println("edit");
			return "edit";
		}
		
		public String update() throws Exception{
			init();	
			//获取不到ISBN  ??
			Book b=bookService.selectBook(book.getISBN());
			b.setBookName(book.getBookName());
			b.setAuthor(book.getAuthor());
			b.setPublisher(book.getPublisher());
			b.setPrice(book.getPrice());
			b.setCnum(book.getCnum());
			b.setSnum(book.getSnum());
			bookService.updateBook(b);
			this.setMessage("修改成功！");
			return "success";
		}
		
		
		@Override
		public void prepare() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("prepare...");
		}
		
		private Map<String, Object> request;
		@Override
		public void setRequest(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			System.out.println("setRequest...");
			this.request = arg0;
		}
		@Override
		public Book getModel() {
			// TODO Auto-generated method stub
			System.out.println("getModel...");
			return book;
		}
		//省略上面属性的get和set方法（整理文档时需要添加的）
				public String getMessage(){
					return this.message;
				}
				public int getPageNow() {
					return pageNow;
				}
				public void setPageNow(int pageNow) {
					this.pageNow = pageNow;
				}
				public int getPageSize() {
					return pageSize;
				}
				public void setPageSize(int pageSize) {
					this.pageSize = pageSize;
				}
				public void setMessage(String message){
					this.message = message;
				}
				
				public File getPhoto(){
					return photo;
				}
				public void setPhoto(File photo){
					this.photo = photo;
				}
				
				public Book getBook(){
					return book;
				}
				public void setBook(Book book){
					this.book = book;
				}
				public BookService getBookService() {
					return bookService;
				}
				public void setBookService(BookService bookService) {
					this.bookService = bookService;
				}

				public LendService getLendService() {
					return lendService;
				}

				public void setLendService(LendService lendService) {
					this.lendService = lendService;
				}
				
}
