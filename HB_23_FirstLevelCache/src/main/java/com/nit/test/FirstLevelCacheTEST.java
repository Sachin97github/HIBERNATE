package com.nit.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Account;
import com.nit.utils.HibernateUtill;

public class FirstLevelCacheTEST {

	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;

		Boolean flag = false;

		session = HibernateUtill.openSession();
		tx = session.beginTransaction();

		try{
			Account acc=new Account();
	        acc=session.get(Account.class,182);
	        //First Time hitt data base
	        System.out.println(acc);
	        //stored in first level cache
	        session.save(acc);
	        
	        
	        
			
			 
	 
			
			
			System.out.println("Object Saved");
			
			System.out.println("Modified count :: "+acc.getVersionCount());
			flag=true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag)
				tx.commit();
			else {
				tx.rollback();
				System.out.println("Object NOT Saved");
			}

		}

	}
}
