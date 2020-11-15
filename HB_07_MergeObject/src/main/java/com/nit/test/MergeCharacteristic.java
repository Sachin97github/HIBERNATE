package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class MergeCharacteristic {
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
			//
			// obj=session.get(UserDetails.class,1234l);
			// //Get and Update Object
			// obj.setUsername("SACHIN MERGE UPDATE");
			// //Update if already Exist
			// // obj=(UserDetails) session.merge(obj);
			// //System.out.println(obj);

			obj.setAccno(123459l);
			obj.setUsername("SACHIN MERGE@");
			obj.setPassword("PASS");
			obj.setBalance(5000000d);

			obj = (UserDetails) session.merge(obj);
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
