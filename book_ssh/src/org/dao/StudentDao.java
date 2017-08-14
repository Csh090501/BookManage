package org.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.db.DBConn;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Book;
import org.model.Student;
import org.util.HibernateUtil;
public class StudentDao extends BaseDao{
	Connection conn;
	public Student selectByReaderId(String readerId){
		Transaction transaction =null;
	    String hql ="";
	    try {      
	        Session session = getSession();        
	        transaction =session.beginTransaction();       
	        hql = "from Student where readerId=?";      
	        Query query = session.createQuery(hql);    
	        query.setParameter(0,readerId);
	       
	        List<Student> list =query.list();
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
//		conn=DBConn.getConn();
//		PreparedStatement pstmt=conn.prepareStatement("select * from student where readerId=?");
//		pstmt.setString(1, readerId);
//		ResultSet rs=pstmt.executeQuery();
//		if(rs.next()){
//			Student stu=new Student();
//			stu.setReaderId(rs.getString(1));
//			stu.setName(rs.getString(2));
//			stu.setSex(rs.getBoolean(3));
//			stu.setBorn(rs.getString(4));
//			stu.setSpec(rs.getString(5));
//			stu.setNum(rs.getInt(6));
//			stu.setPhoto(rs.getBytes(7));
//			return stu;
//		}else
//			return null;
//		}catch(Exception e){
//		e.printStackTrace();
//		return null;
//		}finally{
//		DBConn.CloseConn();
//		}
	}
	public void updateStudent(Student stu){
		try{
			conn=DBConn.getConn();
			PreparedStatement pstmt=conn.prepareStatement("update student set num=? where readerId=?");
			pstmt.setInt(1, stu.getNum());
			pstmt.setString(2, stu.getReaderId());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.CloseConn();
		}
	}

}
