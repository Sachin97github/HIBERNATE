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
			
			Project proj1=new Project();
			proj1.setpName("IPHONE");
			proj1.setpCompony("APPLE");
			proj1.setpDuration("ONE MONTH");
					
		    Project proj2=new Project();
			proj2.setpName("SAMSUNG");
			proj2.setpCompony("SAMCUNG");
			proj2.setpDuration("TWO MONTH");
					
		    Project proj3=new Project();
			proj3.setpName("LUMIA");
			proj3.setpCompony("NOKIA");
			proj3.setpDuration("THREE MONTH");
					
	
			new Thread(new MyThread(session,proj1),"T1").start();
			new Thread(new MyThread(session,proj2),"T2").start();
			new Thread(new MyThread(session,proj3),"T3").start();


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
