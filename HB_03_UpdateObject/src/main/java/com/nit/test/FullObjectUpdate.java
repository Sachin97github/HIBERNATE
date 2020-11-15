package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class FullObjectUpdate {
	private static Session session;
	static {
		session = HibernateUtils.getSession();
	}

	public static void main(String[] args) {

		Transaction tx = null;
		boolean flag = false;
		UserDetails obj = new UserDetails();
		obj.setAccno(1234321);

		// obj.setUsername("sachin");
		// obj.setPassword("camelNotation");
		// obj.setBalance(700000d);

		// Update Object
		obj.setUsername("SachinMOD");
		obj.setPassword("camelNotationMod");
		obj.setBalance(800000d);

		tx = session.beginTransaction();
		try {
			session.update(obj);
			flag = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Obejct Saved");
			} else {
				tx.rollback();
				System.out.println("Object Not Saved");
			}
		}

	}

}
