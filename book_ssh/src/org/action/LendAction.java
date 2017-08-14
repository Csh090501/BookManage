package org.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dao.BookDao;
import org.dao.LendDao;
import org.dao.StudentDao;
import org.model.Book;
import org.model.Lend;
import org.model.Student;
import org.service.BookService;
import org.service.LendService;
import org.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LendAction extends ActionSupport{
	private int pageNow=1;   				 //初始页面为第一页
	private int pageSize=4;   				 //每页显示4天记录
	private Lend lend;
	private String message;
	private LendService lendService=null;
	private StudentService studentService=null;
	private BookService bookService;
	
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    studentService = (StudentService) ctx.getBean("studentService");
	    lendService = (LendService) ctx.getBean("lendService");
	    bookService = (BookService) ctx.getBean("bookService");
	}	
	
//	LendDao lendDao=new LendDao();
	public String selectAllLend() throws Exception{
		init();
		//判断输入的借书证号是否为空
		if(lend.getReaderId()==null||lend.getReaderId().equals("")){
			this.setMessage("请输入借书证号！");
			return SUCCESS;
		}else if(studentService.selectByReaderId(lend.getReaderId())==null){
	     //调用StudentDao中的查询学生的方法，如果为null就表示输入的借书证号不存在
			this.setMessage("不存在该学生！");
			return SUCCESS;
		}
		//调用LendDao的查询已借图书方法，查询，这里用到了分页查询
		List<Lend> list=lendService.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
		//根据当前页及一共多少条记录创建分页的类Pager对象
		Pager page=new Pager(pageNow,lendService.selectLendSize(lend.getReaderId()));
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("list", list);     					//保存查询的记录
		request.put("page", page);   				//保存分页记录
		request.put("readerId", lend.getReaderId());  		//保存借书证号
		return SUCCESS;
	}
	
	public String lendBook()throws Exception{
		init();
//		BookDao bookDao=new BookDao();
		//如果ISBN为空或者不存在该ISBN的书，就返回到原来的情况，只是多了提示信息
		if(lend.getISBN()==null || lend.getISBN().equals("")||bookService.selectBook(lend.getISBN())==null||(bookService.selectBook(lend.getISBN()).getSnum())<1){
			List list=lendService.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
			Pager page=new Pager(pageNow,lendService.selectLendSize(lend.getReaderId()));
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			setMessage("ISBN不能为空或者不存在该ISBN的图书或者该ISBN的图书没有库存量！");
			return SUCCESS;
		}
//		BookDao bookDao = new BookDao();
		Lend l=lend;
	    Book currentBook = new Book();
	    currentBook = bookService.selectBook(lend.getISBN());
	    l.setReaderId(lend.getReaderId());    					//设置借书证号
	    l.setBookName(currentBook.getBookName());
	    l.setPublisher(currentBook.getPublisher());
	    l.setPrice(currentBook.getPrice());
		l.setISBN(currentBook.getISBN());         					//设置图书ISBN
		
		l.setlTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));            					//设置借书时间为当前时间
		lendService.addLend(l);  
						
		Book book=bookService.selectBook(lend.getISBN());  	 	//取得该ISBN的图书对象
		book.setSnum(book.getSnum()-1);			  			//设置库存量-1
		bookService.updateBook(book);				  			//修改图书
//		StudentDao studentDao=new StudentDao();
		Student stu=studentService.selectByReaderId(lend.getReaderId());
		stu.setNum(stu.getNum()+1);					  		//设置学生的借书量+1
		studentService.updateStudent(stu);
		List list=lendService.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
		Pager page=new Pager(pageNow,lendService.selectLendSize(lend.getReaderId()));
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderId());
		this.setMessage("借书成功!");
		return SUCCESS;
		
	}
	
	public String returnBook()throws Exception{
		init();
//		LendDao lendDao = new LendDao();
//		BookDao bookDao=new BookDao();
		//如果ISBN为空或者不存在该ISBN的书，就返回到原来的情况，只是多了提示信息
		if(lend.getISBN()==null||lend.getISBN().equals("")||lendService.selectByBookISBN(lend.getISBN(), lend.getReaderId())==null){
			setMessage("ISBN不能为空或者您没有借该书!");
			return SUCCESS;
		}  
//		Lend lend1 = lendDao.selectByBookISBN(lend.getISBN(), lend.getReaderId());
		if(lendService.deleteLend(lend.getISBN(),lend.getReaderId())){
			Book book=bookService.selectBook(lend.getISBN());  	 	//取得该ISBN的图书对象
			book.setSnum(book.getSnum()+1);			  			//设置库存量+1
			bookService.updateBook(book);				  			//修改图书
//			StudentDao studentDao=new StudentDao();
			Student stu=studentService.selectByReaderId(lend.getReaderId());
			stu.setNum(stu.getNum()-1);					  		//设置学生的借书量-1
			studentService.updateStudent(stu);
			List list=lendService.selectLend(lend.getReaderId(),this.getPageNow(),this.getPageSize());
			Pager page=new Pager(pageNow,lendService.selectLendSize(lend.getReaderId()));
			Map request=(Map) ActionContext.getContext().get("request");
			request.put("list", list);
			request.put("page", page);
			request.put("readerId", lend.getReaderId());
			this.setMessage("还书成功!");
			return SUCCESS;
		}else{
			this.setMessage("还书失败!");
			return SUCCESS;
		}
		
	}

	public LendService getLendService() {
		return lendService;
	}
	public void setLendService(LendService lendService) {
		this.lendService = lendService;
	}
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	//这里省略上面属性的get和set方法（整理文档时需要添加的）
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow){
		this.pageNow = pageNow;
	}
	
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
	
	public Lend getLend(){
		return lend;
	}
	public void setLend(Lend lend){
		this.lend = lend;
	}
	
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
