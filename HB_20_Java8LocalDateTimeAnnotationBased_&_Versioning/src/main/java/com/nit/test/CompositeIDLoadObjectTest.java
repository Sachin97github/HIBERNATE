package com.nit.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
			obj.setBirthDate(LocalDate.of(1997,12,1));
			obj.setPreDate(LocalTime.now());
			obj.setRegDate(LocalDateTime.of(1997,12,1,12,45,50));
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
