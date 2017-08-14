package org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public Session getSession(){
		Session session=sessionFactory.openSession();
		return session;
	}
	
}
