package com.nit.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {
	private static SessionFactory factory;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();
	
	static
	{
		 factory=new Configuration().configure("com/nit/cfgs/hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session openSession()
	{
		  if(threadLocal.get()==null)
		       threadLocal.set(factory.openSession());			  
		  return threadLocal.get();
	}
	
	public static void closeSession()
	{
		threadLocal.get().close();
	}
	
	public static void closeFactory()
	{
		factory.close();
	}

}
