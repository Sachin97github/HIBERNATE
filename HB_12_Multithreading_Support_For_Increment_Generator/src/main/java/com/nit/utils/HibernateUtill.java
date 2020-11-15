package com.nit.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {

	private static SessionFactory factory;
	private static Session session;
	
	static 
	{
	  factory=new Configuration().configure("src/main/java/com/nit/cfgs/hibernate.cfg.xml").buildSessionFactory();
	 
	}
	
	public static Session openSession()
	{
		if(factory!=null)
			{
			session=factory.openSession();
			return session;
			}
		else
			return null;
	}
	public static void closeSession()
	{
		session.close();
	}
	
	public static void closeFactory()
	{
		 factory.close();
	}
	
}
