package com.nit.utills;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MysqlHibernateUtil {
	
	public static SessionFactory  factory=null;
	
	static 
	{
		try{
			     factory=new Configuration().configure("com/nit/cfgs/mysql-hibernate.cfg.xml").buildSessionFactory();
		  }
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
	}//static

	public static Session  getSession()
	{
		Session ses=null;
	     if(factory!=null)
	    	  ses=factory.getCurrentSession();
	     else
	    	 System.out.println("Problem while creating Session Factory");
	     return ses;
	     }
	public void closeSessionFactory()
	{
		factory.close();
	}
	
}
