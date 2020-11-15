package com.nit.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.utills.OracleHibernateUtil;

public class QueryExample {

	
	 public static void main(String[] args) {
		 String GET_NAME="SELECT name FROM com.nit.entity.InsurancePolicy where id=:id";
		 	 
		 Session ses=OracleHibernateUtil.getSession();
		Transaction tx=ses.beginTransaction();
        
		Query query=ses.createQuery(GET_NAME);
		query.setParameter("id",25);
		
	try
	{
		//List<String> result=query.getResultList();
	   //	String result2=(String) query.getSingleResult();
		//System.out.println(result2);
		tx.commit();
	}
	catch(HibernateException ex)
	{
		ex.printStackTrace();
	}
		
	}
		
}
