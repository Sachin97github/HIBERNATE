package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class DiffrenceBwMergeAndSaveOrUpdate {
	private static Session session;
	static {
		session = HibernateUtils.getSession();
	}

	public static void main(String[] args) {

		Transaction tx = null;
		boolean flag = false;
		UserDetails obj = new UserDetails();
		tx=session.beginTransaction();
		
		try {
			obj=session.get(UserDetails.class,1234l);
			System.out.println(obj);
			//Stored in lvl cache
			UserDetails obj1=new UserDetails();
			obj1.setAccno(1234l);
			obj1.setUsername("sachin");
			obj1.setUsername("Password2");
			obj1.setBalance(8000000d);
			
			//WILL GIVE NONUNIQUEEXCEPTION because get() will stored object in lvl one catch
			//session.saveOrUpdate(obj1);
			//session.update(obj1);
			obj1=(UserDetails) session.merge(obj1);
			System.out.println(obj1);
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
