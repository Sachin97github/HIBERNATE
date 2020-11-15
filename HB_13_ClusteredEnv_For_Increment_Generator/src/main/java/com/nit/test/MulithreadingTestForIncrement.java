package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Project;
import com.nit.threads.MyThread;
import com.nit.utils.HibernateUtill;

public class MulithreadingTestForIncrement {
	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;
		

		try {
			session=HibernateUtill.openSession();
			tx=session.beginTransaction();
			Project proj1=new Project();
			proj1.setpName("IPHONE");
			proj1.setpCompony("APPLE");
			proj1.setpDuration("ONE MONTH");
					
            session.save(proj1);
            System.out.println("Object Saved");

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println("Exception Raised");
			e.printStackTrace();
		} 
		catch(Exception e)
		{
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			tx.commit();
			HibernateUtill.closeSession();
			HibernateUtill.closeFactory();
		}
	}// Main

}// Class
