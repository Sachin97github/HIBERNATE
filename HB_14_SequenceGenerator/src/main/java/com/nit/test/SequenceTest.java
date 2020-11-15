package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Project;

import com.nit.utils.HibernateUtill;

public class SequenceTest {
	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;
		Project proj=null;

		try {
			session=HibernateUtill.openSession();
			tx=session.beginTransaction();
			
			proj=new Project();
			proj.setpName("PROJECT");
			proj.setpCompony("COMPONY");
			proj.setpDuration("DURATION");
					
            session.save(proj);
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
