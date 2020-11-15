package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.Person;
import com.nit.utills.OracleHibernateUtil;

public class DataFetch {

	public static void main(String[] args)
	{
		
		Session ses=null;
		Transaction tx=null;
		Boolean flag=false;
		ses=OracleHibernateUtil.getSession();
		
		try
		{
			if(!ses.getTransaction().isActive())
				  tx=ses.beginTransaction();
			Query<Person> qry=ses.createQuery("from Employee");
			
			qry.getResultList().forEach(System.out::println);   
			   System.out.println("Objects Fetched");
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
    	}
		catch(Exception ex)
		{
			ex.printStackTrace();
    	}
	
		}
		
	}


