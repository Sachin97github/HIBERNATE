package com.nit.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;
import com.nit.utills.OracleHibernateUtil;

public class DeletePerson {

	public static void main(String[] args) {

		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = null;
		Boolean flag = false;
		try {
			
			  if(!ses.getTransaction().isActive())
			        tx=ses.beginTransaction();
			  
				/*  // it will make Child Record  as Orphan
				 * Person per=new Person(); per.setId(1); ses.delete(per);
				 */
			       //  First Load than delete It won't Make
				  Person per=new Person(); per=ses.load(Person.class,2);
				  ses.delete(per);
				 
			
			  

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
				System.out.println("Object Deleted");
			} else {
				tx.rollback();
				System.out.println("Object not deleted");
			}
	}
}

}
