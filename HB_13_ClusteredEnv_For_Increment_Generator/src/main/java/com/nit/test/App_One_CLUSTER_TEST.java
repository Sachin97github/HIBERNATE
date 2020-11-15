package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Project;
import com.nit.threads.MyThread;
import com.nit.utils.HibernateUtill;

public class App_One_CLUSTER_TEST {
	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;
		Integer idVal=null;
		try {
			session=HibernateUtill.openSession();
			tx=session.beginTransaction();
			Project proj1=new Project();
			proj1.setpName("OpenFx");
			proj1.setpCompony("POLARSIS");
			proj1.setpDuration("TWO MONTH");
			
		
		  idVal=	(Integer) session.save(proj1);
			
		  Thread.sleep(50000);
		
		 System.out.println("Genrated id for App One :: "+idVal);
			
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
