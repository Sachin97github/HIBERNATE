package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Project;
import com.nit.utils.HibernateUtill;

public class AnnotationTest {
public static void main(String[] args) {
	
	 Session session=null;
	 Transaction tx=null;
	 Project proj=null;
	
	 
	 
	 proj=new Project();
	 try
	 {
		 session=HibernateUtill.openSession();
		 tx=session.beginTransaction();
		 
		 //Set values to Entity Class
		 proj.setProID(124L);
		proj.setpName("BANKING");
		 proj.setpCompony("APPLE");
		 proj.setpDuration("TWO MONTHS");
		 proj.setTransientTest("WILL NOT PARTICIPATE IN DATA PERSISTENCE");
		 session.save(proj);
		 System.out.println("Object Stored");
	 }
	 catch(HibernateException e)
	 {
		 tx.rollback();
		 System.out.println("Object not Stored");
		  e.printStackTrace(); 
	 }
	 finally
	 {
		 tx.commit();
		 HibernateUtill.closeSession();
		 HibernateUtill.closeFactory();
	 }
}//Main

}//Class
