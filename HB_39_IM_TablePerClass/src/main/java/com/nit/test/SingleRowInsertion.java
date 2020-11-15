package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Employee;
import com.nit.entity.Person;
import com.nit.entity.Student;
import com.nit.utills.OracleHibernateUtil;

public class SingleRowInsertion {

	public static void main(String[] args)
	{
		
		Session ses=null;
		Transaction tx=null;
		Boolean flag=false;
		ses=OracleHibernateUtil.getSession();
		
		try
		{
			if(!ses.getTransaction().isActive())
				  tx=ses.beginTransaction();
			
			Student std=new Student();
			// Super class Methods and Field does not Participate
			// in persistance 
	        std.setStd("StdSR");
			std.setMarks(456);
			std.setName("NameSR");
			std.setAddress("AddressSR");
			ses.save(std);
			flag=true;
			}
		catch(HibernateException ex)
		{
			flag=false;
			ex.printStackTrace();
    	}
		catch(Exception ex)
		{
			flag=false;
			ex.printStackTrace();
    	}
		finally {
		       if(flag)
		       {
		    	   tx.commit();
		    	   System.out.println("Objects Are Saved");
		       }
		       else
		       {
		    	   tx.rollback();
		    	   System.out.println("Objects not saved");
		       }
		}
		
	}

}
