package com.nit.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.Project;
import com.nit.utils.HibernateUtill;

public class AnnotationTest {
	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;
		Project project = null;

		try {
			System.out.println("+================");
			session = HibernateUtill.openSession();
			System.out.println(session);
			tx = session.beginTransaction();
			System.out.println("AnnotationTest.main()");

			project = new Project();
			project.setpName("SMS 1");
			project.setpDuration("THREE MONTHS 1");
			project.setpCompony("NATIVE 1");
			System.out.println("First Object Saving........ ");
			System.out.println(session.save(project) + " : : Generated value ");

			project.setpName("TICKET BOOKING 2");
			project.setpDuration("THREE MONTHS 2");
			project.setpCompony("CAMELNOTATION 2");

			System.out.println(session.save(project) + " : : Generated value ");

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println("Exception Raised");
			e.printStackTrace();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			tx.commit();
			HibernateUtill.closeSession();
			HibernateUtill.closeFactory();
		}
	}// Main

}// Class
