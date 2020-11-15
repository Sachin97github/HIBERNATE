package com.nit.test;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.utills.OracleHibernateUtil;

public class SelectOnlyUnmarkedTest {

	public static void main(String[] args) {

		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = null;
		Boolean flag = null;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			Query query = ses.createQuery(" from BankAccount"); 
			query.getResultList().forEach(System.out::println);
           flag=true;
		} catch (HibernateException ex) {
			flag = false;
		} catch (Exception ex) {
			flag = false;
		} finally {
			if (flag == true) {
				tx.commit();
				System.out.println("Accounts Fetched");
			} else {
				tx.rollback();
				System.out.println("Accounts not Fetched ");
			}
		}

	}
}
