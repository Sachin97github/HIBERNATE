package com.nit.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Project;
import com.nit.model.ProjectProxyInterface;
import com.nit.utils.HibernateUtill;

public class AnnotationTest {
public static void main(String[] args) {
	
	 Session session=null;
	 Transaction tx=null;
	 ProjectProxyInterface proxy=null;

	 try
	 {
		 session=HibernateUtill.openSession();
		 tx=session.beginTransaction();
		 
		 //Get Obejct(a Row)
		 
		 proxy=session.load(ProjectProxyInterface.class,124l);
		 System.out.println("SuperClass :: "+proxy.getClass().getSuperclass()+"\n Interfaces :: "+Arrays.toString(proxy.getClass().getInterfaces()));
		 System.out.println("-------------------------Object Found---------------------");
		 System.out.println("----------------------Lazy/Eager check------------------");
		 System.out.println(proxy);
	 }
	 catch(HibernateException e)
	 {
		 tx.rollback();
		 System.out.println("Exception Raised");
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
