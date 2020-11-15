package com.nit.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;
import com.nit.utills.OracleHibernateUtil;

public class AADataInsertion {

	public static void main(String[] args) {

		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = null;
		Boolean flag = false;
		try {
			
			  if(!ses.getTransaction().isActive())
			        tx=ses.beginTransaction();
			  
			Person per = new Person();
			per.setName("Sachin");
			per.setGender("Male");
			per.setAddress("Bpl");
	      
			PhoneNumber ph = new PhoneNumber();
			ph.setNumber(73544534L);
			ph.setProvider("BSNL");
			ph.setNumberType("HOME");

			PhoneNumber ph1 = new PhoneNumber();
			ph1.setNumber(1223466l);
			ph1.setProvider("AIRTEL");
			ph1.setNumberType("HOME");
			

			Set<PhoneNumber> phones = new HashSet();
			phones.add(ph);
			phones.add(ph1);
			
			per.setPhones(phones);	
			ses.save(per);
			
			flag = true;
		} catch (HibernateException he) {
			flag = false;
			he.printStackTrace();
		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Object Saved");
			} else {
				tx.rollback();
				System.out.println("Object not Saved");
			}
	}
}

}
