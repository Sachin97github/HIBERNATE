package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class LoadObjectThanDelete {
	private static Session session;
	static {
		session = HibernateUtils.getSession();
	}

	public static void main(String[] args) {

		Transaction tx = null;
		boolean flag = false;
		UserDetails obj = null;
		
		tx = session.beginTransaction();
		try {
			//First get a object
			 obj=session.get(UserDetails.class,1234l);
			 //Get Object
		    System.out.println("Before :: ");
		    System.out.println(obj);
		    
		    //By the time Change values in DB by SQL cmdline
		    Thread.sleep(10000);
		   
		    //Call Refresh :: Changes that have made in DB will reflect here
		    session.refresh(obj);
		    
		   System.out.println(obj);
		    
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Obejct Updated");
			} else {
				tx.rollback();
				System.out.println("Object Not Updated");
			}
		}

	}

}
