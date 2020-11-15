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
			 obj=session.get(UserDetails.class,12345l);
			 System.out.println("--------------BEFORE DELETE-----------");
			 System.out.println(obj);
			 
			 //Than Delete Object
			 session.delete(obj);			 
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Obejct Deleted");
			} else {
				tx.rollback();
				System.out.println("Object Not Deleted");
			}
		}

	}

}
