package com.nit.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;
import com.nit.utills.OracleHibernateUtil;

public class DeleteAChildFromParent {

	public static void main(String[] args) {

		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = null;
		Boolean flag = false;
		try {
			
			  if(!ses.getTransaction().isActive())
			        tx=ses.beginTransaction();
			 Person per=new Person();
			 per=ses.get(Person.class,4);
			 
			 List<PhoneNumber> list=per.getPhones();
			 System.out.println(list.get(0)+" is about to remove");
			 // remove zeroth Index data  list.index(0) == base ="1"
			 // here We dnt have to explicitly call Child Object
			 list.remove(0);
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
				System.out.println("Child record Deleted");
			} else {
				tx.rollback();
				System.out.println("Child not deleted");
			}
	}
}

}
