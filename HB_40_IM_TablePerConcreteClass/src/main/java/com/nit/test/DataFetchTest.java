package com.nit.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.Person;
import com.nit.utills.OracleHibernateUtil;

public class DataFetchTest {

	public static void main(String[] args)
	{
		
		Session ses=null;
		Transaction tx=null;
		Boolean flag=false;
		ses=OracleHibernateUtil.getSession();
		
			if(!ses.getTransaction().isActive())
				  tx=ses.beginTransaction();
			
				/*
				 * Person per=ses.get(Person.class,1); Student std=ses.get(Student.class,2);
				 * Employee emp=ses.get(Employee.class,3); System.out.println(per);
				 * System.out.println(std); System.out.println(emp);
				 */
		
			Query <Person> qry=ses.createQuery("From Person");
            qry.getResultList().forEach(System.out::println);
		   
		
		
		
	}

}
