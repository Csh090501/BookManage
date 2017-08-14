package org.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.db.DBConn;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Book;
import org.model.Lend;
import org.util.HibernateUtil;
public class LendDao extends BaseDao{
Connection conn;
public List selectLend(String readerId,int pageNow,int pageSize){
//	Transaction transaction =null;
//    String hql ="";
//    try {      
//        Session session = HibernateUtil.getSessionFactory().openSession();        
//        transaction =session.beginTransaction();       
//        hql = "from Lend where readerId=? order by ? ,ISBN";      
//        Query query = session.createQuery(hql);    
//        query.setParameter(0,readerId);
//        query.setParameter(1,readerId);
//        query.setFirstResult(pageSize*(pageNow-1));
//        query.setMaxResults(pageSize);
//        
//        List<Lend> list =query.list();
//        for(Lend l:list){
//            System.out.println(l.getISBN()+":"+l.getBookName());
//         }  
//        transaction.commit();
//       
//        if(list.size()>0){
//            return list;
//        }else {
//            return  null;
//        }
//    }catch (Exception e){
//    	e.printStackTrace();
//    }finally {
//       
//        if(transaction!=null){
//            transaction=null;
//        }
//    }
//   return null;
	
	try{
		List list=new ArrayList();
		conn=DBConn.getConn();
		String sql = "select * from lend where readerId=? limit "+pageSize*(pageNow-1)+","+pageSize+"";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, readerId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			Lend lend=new Lend();
			lend.setReaderId(rs.getString(1));
			lend.setBookName(rs.getString(2));
			lend.setPublisher(rs.getString(3));
			lend.setPrice(rs.getFloat(4));
			lend.setISBN(rs.getString(5));
			lend.setlTime(rs.getString(6));
			list.add(lend);
		}
		return list;
	}catch(Exception e){
		e.printStackTrace();
		return null;
	}finally{
		DBConn.CloseConn();
	}
}
public int selectLendSize(String readerId){
	try{
		conn=DBConn.getConn();
		PreparedStatement pstmt=conn.prepareStatement("select count(*) from lend where readerId=?");
		pstmt.setString(1, readerId);
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

public boolean addLend(Lend lend){
	Transaction transaction =null;
    try {      
        Session session = HibernateUtil.getSessionFactory().openSession();        
        transaction =session.beginTransaction();
        
        session.save(lend);   
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
//	try{
//		conn=DBConn.getConn();
//		PreparedStatement pstmt=conn.prepareStatement("insert into lend values(?,?,?,?,?,?)");
//		pstmt.setString(1, lend.getReaderId());
//		pstmt.setString(2, lend.getBookName());
//		pstmt.setString(3, lend.getPublisher());
//		pstmt.setFloat(4, lend.getPrice());
//		pstmt.setString(5, lend.getISBN());
//		pstmt.setDate(6, new Date(lend.getlTime().getTime()));
//		pstmt.execute();
//		return true;
//	}catch(Exception e){
//		e.printStackTrace();
//		return false;
//	}finally{
//		DBConn.CloseConn();
//	}
}
public Lend selectByBookISBN(String ISBN){
	Transaction transaction =null;
    String hql ="";
    try {      
        Session session = getSession();        
        transaction =session.beginTransaction();       
        hql = "from Lend where ISBN=?";      
        Query query = session.createQuery(hql);    
        query.setParameter(0,ISBN);
       
        Lend lend =(Lend)query.uniqueResult();
        System.out.println(lend);    
        transaction.commit();
        return lend;
    }catch (Exception e){
    	e.printStackTrace();
    }finally {
       
        if(transaction!=null){
            transaction=null;
        }
    }
   return null;
	
//	try{
//		conn=DBConn.getConn();
//		PreparedStatement pstmt=conn.prepareStatement("select * from lend where ISBN=?");
//		pstmt.setString(1, ISBN);
//		ResultSet rs=pstmt.executeQuery();
//		if(rs.next()){
//			Lend lend=new Lend();
//			lend.setReaderId(rs.getString(1));
//			lend.setBookName(rs.getString(2));
//			lend.setPublisher(rs.getString(3));
//			lend.setPrice(rs.getFloat(4));
//			lend.setISBN(rs.getString(5));
//			lend.setlTime(rs.getDate(6));
//			return lend;
//		}else{
//			return null;
//		}
//	}catch(Exception e){
//		e.printStackTrace();
//		return null;
//	}finally{
//		DBConn.CloseConn();
//	}
}

public Lend selectByBookISBN(String ISBN , String readerId){
	
	Transaction transaction =null;
    String hql ="";
    try {      
        Session session = getSession();        
        transaction =session.beginTransaction();       
        hql = "from Lend where ISBN=? and readerId=?";      
        Query query = session.createQuery(hql);    
        query.setParameter(0,ISBN);
        query.setParameter(1, readerId);
        List<Lend> list =query.list();
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
	
//	try{
//		conn=DBConn.getConn();
//		PreparedStatement pstmt=conn.prepareStatement("select * from lend where ISBN=? and readerId=?");
//		pstmt.setString(1, ISBN);
//		pstmt.setString(2, readerId);
//		ResultSet rs=pstmt.executeQuery();
//		if(rs.next()){
//			Lend lend=new Lend();
//			lend.setReaderId(rs.getString(1));
//			lend.setBookName(rs.getString(2));
//			lend.setPublisher(rs.getString(3));
//			lend.setPrice(rs.getFloat(4));
//			lend.setISBN(rs.getString(5));
//			lend.setLTime(rs.getDate(6));
//			return lend;
//		}else{
//			return null;
//		}
//	}catch(Exception e){
//		e.printStackTrace();
//		return null;
//	}finally{
//		DBConn.CloseConn();
//	}
}

public boolean deleteLend(String ISBN, String readerId){
//	Transaction transaction =null;
//    try {      
//        Session session = HibernateUtil.getSessionFactory().openSession();        
//        transaction =session.beginTransaction();
//        
//        session.delete(lend);   
//        transaction.commit();
//        return true;
//    }catch (Exception e){
//    	e.printStackTrace();
//    }finally {    
//        if(transaction!=null){
//            transaction=null;
//        }
//    }
//    return false;
//}
	try{
		conn=DBConn.getConn();
		PreparedStatement pstmt=conn.prepareStatement("delete from lend where ISBN=? and readerId=?");
		pstmt.setString(1, ISBN);
		pstmt.setString(2, readerId);
		pstmt.execute();
		return true;
	}catch(Exception e){
		e.printStackTrace();
		return false;
	}finally{
		DBConn.CloseConn();
	}
}

}
