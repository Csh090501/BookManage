package org.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	 private static SessionFactory sessionFactory;
	    private HibernateUtil(){}
	  
	    public static SessionFactory getSessionFactory(){
	        if(sessionFactory ==null){
	        	Configuration configuration=new Configuration().configure();
				ServiceRegistry serviceRegistry=
					new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
	            return sessionFactory;
	        }else {
	            return sessionFactory;
	        }
	    }

	}
