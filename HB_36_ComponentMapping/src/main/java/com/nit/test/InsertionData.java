package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Address;
import com.nit.entity.Student;
import com.nit.utills.OracleHibernateUtil;

public class InsertionData {
	
	public static void main(String[] args) {
		
	 Session ses=OracleHibernateUtil.getSession();
	 Transaction tx=null;
	 Boolean flag=null;
	
	 try{
		  if(!ses.getTransaction().isActive())
		    tx=ses.beginTransaction();
		  
		  Address addr=new Address();
		  addr.setHouseno(34);
		  addr.setCity("Gadarwara");
		  addr.setDistrict("Narsinghpur");
	      addr.setState("MP");	  
	      addr.setCountry("India");
	      
		  Student std=new Student();
		  std.setSname("Sachin");
		  std.setEmail("Sachin7697@yahoo.com");
		  std.setAddr(addr);
		  
		  ses.save(std);
		  flag=true;
	 }
	 catch(HibernateException ex)
	 {
		 flag=false;
		 ex.printStackTrace();
 }
	 finally
	 {
		 if(flag==true)
		 { 
			 tx.commit();
			 System.out.println("Object Saved");
		 }
		 else
		 {
			 tx.rollback();
			 System.out.println("Object not Saved");
		 }
	 }
	}

}
