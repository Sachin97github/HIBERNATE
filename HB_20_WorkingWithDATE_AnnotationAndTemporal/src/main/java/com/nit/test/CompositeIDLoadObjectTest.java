package com.nit.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Person;
import com.nit.utils.HibernateUtill;

public class CompositeIDLoadObjectTest {

	public static void main(String[] args) {

		Session session = null;
		Transaction tx = null;

		Boolean flag = false;

		session = HibernateUtill.openSession();
		tx = session.beginTransaction();

		try {
			Person obj=new Person();
			
			obj.setpName("SACHIN");
			obj.setBirthDate(new Date(97,12,01,12,45,50));
			obj.setPreDate(new Date(97,12,01,12,45,50));
			obj.setRegDate(new Date(97,12,01,12,45,50));
			
			//MYSQL Data will be Stored as Specified in XML mapping File
			//Time -- time only
			//Timestamp - Date and Time both
			//Date - Date Only
			
			//In Oracle 
			//Time is also saved as Date only date value
			
			session.save(obj);
			System.out.println("OBJECT SAVED");
			flag=true;
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag)
				tx.commit();
			else {
				tx.rollback();
				System.out.println("Object NOT Saved");
			}

		}

	}
}
