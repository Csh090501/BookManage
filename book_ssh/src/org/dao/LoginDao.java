package org.dao;
import java.sql.*;
import java.util.List;

import org.model.*;
import org.util.HibernateUtil;
import org.db.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoginDao extends BaseDao{
	Connection conn;											//数据库连接对象
	public Login checkLogin(String name, String password){		//验证登录用户名和密码
		Transaction transaction =null;
	    String hql ="";
	    try {      
//	    	Session session = HibernateUtil.getSessionFactory().openSession(); 
	    	Session session = getSession(); 
	        transaction =session.beginTransaction();       
	        hql = "from Login where name=? and password =?";      
	        Query query = session.createQuery(hql);    
	        query.setParameter(0,name);
	        query.setParameter(1,password);
	       
	        List<Login> list =query.list();
	        System.out.println(list);    
	        transaction.commit();
	       
	        if(list.size()>0){
	            return list.get(0);
	        }else {
	            return  null;
	        }
	    }catch (Exception e){
	    	if(transaction!=null) transaction.rollback();
	    	e.printStackTrace();
	    }finally {
	       
	        if(transaction!=null){
	            transaction=null;
	        }
	    }
	   return null;
	}
		
		
//		try{
//			conn = DBConn.getConn();							//获取连接对象
//			PreparedStatement pstmt = conn.prepareStatement("select * from login where name=? " + "and password=?");
//			pstmt.setString(1, name);							//设置 SQL 语句参数1（用户名）
//			pstmt.setString(2, password);						//设置 SQL 语句参数2（密码）
//			ResultSet rs = pstmt.executeQuery();				//执行查询，返回结果集
//			if(rs.next()){										//返回结果不为空，表示有此用户信息
//				Login login = new Login();						//通过JavaBean对象保存值
//				login.setId(rs.getInt(1));
//				login.setName(rs.getString(2));
//				login.setPassword(rs.getString(3));
//				login.setRole(rs.getInt(4));
//				return login;									//返回已经设值的JavaBean对象
//			}
//			return null;										//无此用户，验证失败，返回null
//		}catch(Exception e){
//			e.printStackTrace();
//			return null;
//		}finally{
//			DBConn.CloseConn();									//关闭连接
//		}
//	}
	
	public Login checkLogin2(String name){		//验证登录用户名和密码
		try{
			conn = DBConn.getConn();							//获取连接对象
			PreparedStatement pstmt = conn.prepareStatement("select * from login where name=?");
			pstmt.setString(1, name);							//设置 SQL 语句参数1（用户名）

			ResultSet rs = pstmt.executeQuery();				//执行查询，返回结果集
			if(rs.next()){										//返回结果不为空，表示有此用户信息
				Login login = new Login();						//通过JavaBean对象保存值
				login.setId(rs.getInt(1));
				login.setName(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setRole(rs.getInt(4));
				return login;									//返回已经设值的JavaBean对象
			}
			return null;										//无此用户，验证失败，返回null
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.CloseConn();									//关闭连接
		}
	}
}
