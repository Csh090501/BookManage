package org.db;
import java.sql.*;
public class DBConn{
	public static Connection conn;			//Connection对象（连接）
	//获取数据库连接
	public static Connection getConn(){
		try {
			/**加载并注册 SQLServer 2008 的 JDBC 驱动*/
			Class.forName("com.mysql.jdbc.Driver");
			/**编写连接字符串，创建并获取连接*/
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_bookmanage","root","941013");
			return conn;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//关闭连接
	public static void CloseConn(){
		try{
			conn.close();					//关闭连接
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
