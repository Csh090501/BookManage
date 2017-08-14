package org.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.db.DBConn;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Book;
import org.model.Lend;
import org.model.Login;
import org.util.HibernateUtil;
public class BookDao extends BaseDao{
	Connection conn;
	public Book selectBook(String ISBN){
		Transaction transaction =null;
	    String hql ="";
	    try {      
	        Session session = getSession();        
	        transaction =session.beginTransaction();       
	        hql = "from Book where ISBN=?";      
	        Query query = session.createQuery(hql);    
	        query.setParameter(0,ISBN);
	       
	        Book book=(Book) query.uniqueResult();
	        System.out.println(book);    
	        transaction.commit();
	       
	        return book;
	    }catch (Exception e){
	    	e.printStackTrace();
	    }finally {
	       
	        if(transaction!=null){
	            transaction=null;
	        }
	    }
	   return null;
		
//		try{
//			conn=DBConn.getConn();
//			PreparedStatement pstmt=conn.prepareStatement("select * from book where ISBN=?");
//			pstmt.setString(1, ISBN);
//			ResultSet rs=pstmt.executeQuery();
//			if(rs.next()){
//				Book book=new Book();
//				book.setISBN(rs.getString(1));
//				book.setBookName(rs.getString(2));
//				book.setAuthor(rs.getString(3));
//				book.setPublisher(rs.getString(4));
//				book.setPrice(rs.getFloat(5));
//				book.setCnum(rs.getInt(6));
//				book.setSnum(rs.getInt(7));
//				book.setSummary(rs.getString(8));
//				book.setPhoto(rs.getBytes(9));
//				return book;
//			}else
//				return null;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally{
//			DBConn.CloseConn();
//		}
	}
	
	public Book queryBook1(String bookName){
		Transaction transaction =null;
	    String hql ="";
	    try {      
	        Session session = getSession();        
	        transaction =session.beginTransaction();       
	        hql = "from Book where bookName like concat('%',?,'%')";      
	        Query query = session.createQuery(hql);    
	        query.setParameter(0,bookName);
	       
	        List<Book> list =query.list();
	        System.out.println(list);    
	        transaction.commit();
	       
	        if(list.size()>0){
	            return list.get(0);
	        }else {
	            return  null;
	        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }finally {
	       
	        if(transaction!=null){
	            transaction=null;
	        }
	    }
	   return null;
		
//		try{
//			conn=DBConn.getConn();
//			String sql ="select * from book where bookName like concat('%',?,'%')";
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, bookName);
//			ResultSet rs=pstmt.executeQuery();
//			if(rs.next()){
//				Book book=new Book();
//				book.setISBN(rs.getString(1));
//				book.setBookName(rs.getString(2));
//				book.setAuthor(rs.getString(3));
//				book.setPublisher(rs.getString(4));
//				book.setPrice(rs.getFloat(5));
//				book.setCnum(rs.getInt(6));
//				book.setSnum(rs.getInt(7));
//				book.setSummary(rs.getString(8));
//				book.setPhoto(rs.getBytes(9));
//				return book;
//			}else
//				return null;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally{
//			DBConn.CloseConn();
//		}
	}
	
	public List queryBook2(String bookName ,int pageSize ,int pageNow){
		Transaction transaction =null;
	    String hql ="";
	    try {      
	        Session session = getSession();        
	        transaction =session.beginTransaction();       
	        hql = "from Book where bookName like concat('%',?,'%')";      
	        Query query = session.createQuery(hql);    
	        query.setParameter(0,bookName);
	        query.setFirstResult(pageSize*(pageNow-1));
	        query.setMaxResults(pageSize);
	        
	        List<Book> list =query.list();
	        System.out.println(list);    
	        transaction.commit();
	       
	        if(list.size()>0){
	            return list;
	        }else {
	            return  null;
	        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }finally {
	       
	        if(transaction!=null){
	            transaction=null;
	        }
	    }
	   return null;
		
//		try{
//			List list=new ArrayList();
//			conn=DBConn.getConn();
//			String sql ="select * from book where bookName like concat('%',?,'%') limit "+pageSize*(pageNow-1)+","+pageSize+"";
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, bookName);
//			ResultSet rs=pstmt.executeQuery();
//			while(rs.next()){
//				Book book = new Book();
//				book.setISBN(rs.getString(1));
//				book.setBookName(rs.getString(2));
//				book.setAuthor(rs.getString(3));
//				book.setPublisher(rs.getString(4));
//				book.setPrice(rs.getFloat(5));
//				book.setCnum(rs.getInt(6));
//				book.setSnum(rs.getInt(7));
//				list.add(book);
//			}
//			return list;
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally{
//			DBConn.CloseConn();
//		}
	}
	
	public int selectBookSize(String bookName){
//		Transaction transaction =null;
//	    String hql ="";
//	    try {      
//	        Session session = HibernateUtil.getSessionFactory().openSession();        
//	        transaction =session.beginTransaction();       
//	        hql = "select count(*) from Book where bookName=?";      
//	        Query query = session.createQuery(hql);    
//	        query.setParameter(0,bookName);
//	       
//	        List<Integer> list =query.list();
//	        System.out.println(list);    
//	        transaction.commit();
//	       
//	        if(list.size()>0){
//	            return list.get(0);
//	        }else {
//	            return  0;
//	        }
//	    }catch (Exception e){
//	    	e.printStackTrace();
//	    }finally {
//	       
//	        if(transaction!=null){
//	            transaction=null;
//	        }
//	    }
//	   return 0;
		try{
			conn=DBConn.getConn();
			PreparedStatement pstmt=conn.prepareStatement("select count(*) from book where bookName like concat('%',?,'%')");
			pstmt.setString(1, bookName);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				int pageCount=rs.getInt(1);
				return pageCount;
			}
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			DBConn.CloseConn();
		}
	}
	
	public boolean updateBook(Book book){
		Transaction transaction =null;
	    try {      
	        Session session = getSession();        
	        transaction =session.beginTransaction();
	        Book bookCurrent = (Book) session.get(Book.class, book.getISBN());
	        bookCurrent.setBookName(book.getBookName());
	        bookCurrent.setAuthor(book.getAuthor());
	        bookCurrent.setPublisher(book.getPublisher());
	        bookCurrent.setPrice(book.getPrice());
	        bookCurrent.setCnum(book.getCnum());
	        bookCurrent.setSnum(book.getSnum());
	        bookCurrent.setSummary(book.getSummary());
	        bookCurrent.setPhoto(book.getPhoto());
	        session.update(bookCurrent);   
	        transaction.commit();
	        return true;
	    }catch (Exception e){
	    	e.printStackTrace();
	    }finally {
	       
	        if(transaction!=null){
	            transaction=null;
	        }
	    }
		return false;
//		try{
//			conn=DBConn.getConn();
//			PreparedStatement pstmt=conn.prepareStatement("update book set bookName=?,author=?,publisher=?,price=?,cnum=?,snum=?,summary=?,photo=? where ISBN=?");
//			pstmt.setString(1, book.getBookName());
//			pstmt.setString(2, book.getAuthor());
//			pstmt.setString(3, book.getPublisher());
//			pstmt.setFloat(4, book.getPrice());
//			pstmt.setInt(5, book.getCnum());
//			pstmt.setInt(6, book.getSnum());
//			pstmt.setString(7, book.getSummary());
//			pstmt.setBytes(8, book.getPhoto());
//			pstmt.setString(9, book.getISBN());
//			pstmt.execute();
//			return true;
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally{
//			DBConn.CloseConn();
//		}
	}
	
	public boolean addBook(Book book){
		Transaction transaction =null;
	    try {      
	        Session session = getSession();        
	        transaction =session.beginTransaction();
	        
	        session.save(book);   
	        transaction.commit();
	        return true;
	    }catch (Exception e){
	    	e.printStackTrace();
	    }finally {
	       
	        if(transaction!=null){
	            transaction=null;
	        }
	    }
//		try{
//			conn=DBConn.getConn();
//			PreparedStatement pstmt=conn.prepareStatement("insert into book values(?,?,?,?,?,?,?,?,?)");
//			pstmt.setString(1, book.getISBN());
//			pstmt.setString(2, book.getBookName());
//			pstmt.setString(3, book.getAuthor());
//			pstmt.setString(4, book.getPublisher());
//			pstmt.setFloat(5, book.getPrice());
//			pstmt.setInt(6, book.getCnum());
//			pstmt.setInt(7, book.getSnum());
//			pstmt.setString(8, book.getSummary());
//			pstmt.setBytes(9, book.getPhoto());
//			pstmt.execute();
//			return true;
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally{
//			DBConn.CloseConn();
//		}
	    return false;
	}
	
	public boolean deleteBook(Book book){
		Transaction transaction =null;
	    try {      
	        Session session = getSession();        
	        transaction =session.beginTransaction();
	        
	        session.delete(book);   
	        transaction.commit();
	        return true;
	    }catch (Exception e){
	    	e.printStackTrace();
	    }finally {
	       
	        if(transaction!=null){
	            transaction=null;
	        }
	    }
		return false;
//		try{
//			conn=DBConn.getConn();
//			PreparedStatement pstmt=conn.prepareStatement("delete from book where ISBN=?");
//			pstmt.setString(1, ISBN);
//			pstmt.execute();
//			return true;
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally{
//			DBConn.CloseConn();
//		}
	}

}
