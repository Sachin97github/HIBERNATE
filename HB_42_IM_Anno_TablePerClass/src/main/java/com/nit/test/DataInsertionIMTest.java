package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Employee;
import com.nit.entity.Person;
import com.nit.entity.Student;
import com.nit.utills.OracleHibernateUtil;

public class DataInsertionIMTest {

	public static void main(String[] args) {

		Session ses = null;
		Transaction tx = null;
		Boolean flag = false;
		ses = OracleHibernateUtil.getSession();

		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

			Person per = new Person();
			per.setName("PersonAnno_One");
			per.setAddress("Address_Anno_ONE");
			
			  Student std = new Student();
			  std.setName("Name_ONE");
			  std.setAddress("BPL");
			  std.setStd("12th"); std.setSchool("School");
			  std.setMarks(456);
			 
				
				  Employee emp = new Employee(); emp.setName("Sachin"); emp.setAddress("HYD");
				  emp.setDesg("Dev"); emp.setCompany("Oracle"); emp.setSalary(344444d);
				 
			 
			ses.save(per);
			
			  ses.save(std);
	         ses.save(emp);
			 
			flag = true;

		} catch (HibernateException ex) {
			flag = false;
			ex.printStackTrace();
		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("Objects Are Saved");
			} else {
				tx.rollback();
				System.out.println("Objects not saved");
			}
		}

	}

}
