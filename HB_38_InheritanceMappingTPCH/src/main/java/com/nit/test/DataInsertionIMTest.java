package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Employee;
import com.nit.entity.Person;
import com.nit.entity.Student;
import com.nit.utills.OracleHibernateUtil;

public class DataInsertionIMTest {

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
			
			for(int i=1;i<=12;i++)
			{
				Person per=new Person();
				per.setName("Name_"+i);
				per.setAddress("Address_"+i);
			  
				Student std=new Student("std_"+i,"School_"+i,50+i);
				Employee emp=new Employee("Desg_"+i,"Company_"+i,(double)50+i);
			   
				ses.save(per);
				ses.save(std);
				ses.save(emp);			   
			   flag=true;				
			}
				
			
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
