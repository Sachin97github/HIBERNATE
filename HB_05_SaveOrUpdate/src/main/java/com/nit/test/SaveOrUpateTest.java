package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class SaveOrUpateTest {
	private static Session session;
	static {
		session = HibernateUtils.getSession();
	}

	public static void main(String[] args) {

		Transaction tx = null;
		boolean flag = false;
		UserDetails obj = new UserDetails();
		
		obj.setAccno(1234);
		obj.setUsername("Ashish");
		obj.setPassword("patelAshish");
		obj.setBalance(90000000d);
		
		tx = session.beginTransaction();
		try {
			  //Save if not Available if available thn Update Object
			//  ! available ? save : update ;
			session.saveOrUpdate(obj); 
			
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Record Updated");
			} else {
				tx.rollback();
				System.out.println("Record not Updated");
			}
		}

	}

}
