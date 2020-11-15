package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.model.UserDetails;
import com.nit.util.HibernateUtils;

public class PartiallyObjectUpdate {

	private static Session session;
	static {
		session = HibernateUtils.getSession();
	}

	public static void main(String[] args) {
		
		  Transaction tx=null;
		  boolean flag=false;
		  UserDetails obj=new UserDetails();
		  
		  tx=session.beginTransaction();
		 try{
		   //First get Desried Object with get() Method
			   obj=session.get(UserDetails.class,1234321l);
			    //After that Modify according to your need
			   obj.setUsername("SACHIN_AFTER_UPDATE");
			   //Than save the Object
			   session.update(obj);
			   flag=true;
		 }//try
		 catch(HibernateException e)
		 {
			 e.printStackTrace();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 if(flag)
			 {
				 tx.commit();
				 System.out.println("Obejct Saved");	     
			 }
			 else
			 {
				 tx.rollback();
				 System.out.println("Object Not Saved");
			 }
		 }//finally
	}//main
}//class
	  
	     

