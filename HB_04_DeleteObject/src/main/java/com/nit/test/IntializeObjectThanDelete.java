package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class IntializeObjectThanDelete {
	private static Session session;
	static {
		session = HibernateUtils.getSession();
	}

	public static void main(String[] args) {

		Transaction tx = null;
		boolean flag = false;
		UserDetails obj = new UserDetails();
		
		obj.setAccno(1234321);
		
		tx = session.beginTransaction();
		try {
			//Object associated to ID
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
