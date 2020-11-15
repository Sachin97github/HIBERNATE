package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nit.utils.HibernateUtill;

public class CreatePropertyTest {

	public static void main(String[] args) {
		
		Session session=null;
		Boolean flag;

	
		try
		{
			session=HibernateUtill.openSession();
			System.out.println("INITAILIZED");
			
		}
		 catch(HibernateException he)
		{
			 he.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			HibernateUtill.closeSession();
			HibernateUtill.closeFactory();
			System.out.println("CONNECTION CLOSED");
		}
		
	}
}
