package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class HibernateLvlOneCatchExample {
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
			//At the time of loading object it will Stored in session cache 
			//if you want to get Object with same primary value
			// It won't hit dataBase 2nd time
			  obj=session.get(UserDetails.class,1234l);
			  System.out.println(obj);
					obj.setBalance(80000000d);
			  System.out.println("-----------------------------------------------------------------------------");
			  obj=session.get(UserDetails.class,1234l);
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
