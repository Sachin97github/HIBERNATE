package com.nit.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.Student;
import com.nit.utills.OracleHibernateUtil;

public class DataFetching {

	public static void main(String[] args) {

		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = null;
		Boolean flag = null;

		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			//Transaction Req Only For Contextual Session
			
			Query<Student>qry=ses.createQuery("from Student");
			qry.getResultList().forEach(System.out::println);
			

		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

}
