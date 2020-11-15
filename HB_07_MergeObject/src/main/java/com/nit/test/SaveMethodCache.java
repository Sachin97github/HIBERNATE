package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class SaveMethodCache {
	private static Session session;
	static {
		session = HibernateUtils.getSession();
	}

	public static void main(String[] args) {

		Transaction tx = null;
		boolean flag = false;
		UserDetails obj = new UserDetails();

		tx = session.beginTransaction();
		try {
			obj = session.get(UserDetails.class, 1234l);
			UserDetails obj2 = new UserDetails();
			obj2.setAccno(1234l);
			obj2.setUsername("SACHIN UPdate");
			obj2.setPassword("Pass");
			obj2.setBalance(7000000d);

			// session.update(obj2);
			// Non unique Object Exception
			// session.save(obj2);
			// Non unique Object Exception

			// At time of get() object with primary stored in Cache (lvl one)
			// So merge() comes in picture

			session.merge(obj2);
			// it will update Obj

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
