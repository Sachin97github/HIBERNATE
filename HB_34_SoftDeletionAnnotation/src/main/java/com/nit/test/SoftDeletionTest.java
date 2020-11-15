package com.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.BankAccount;
import com.nit.utills.OracleHibernateUtil;

public class SoftDeletionTest{

	public static void main(String[] args) {
		
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=null;
	    Boolean flag=null;
	  try
	  {
	      if(!ses.getTransaction().isActive())
		        tx=ses.beginTransaction();
		    BankAccount acc=new BankAccount();
		    acc.setAccount(67);
		    ses.delete(acc);
		   flag=true;
	  }
	  catch(HibernateException ex)
	  {
		  flag=false;
	  }
	  catch(Exception ex)
	  {
		  flag=false;
	  }
	  finally
	  {
		  if(flag==true)
		  {
			  tx.commit();
			  System.out.println("Account marked Deleted");
		  }
		  else
		  {
			  tx.rollback();
			  System.out.println("Account not Marked/Deleted");
	    }
	  }
	  
	   
	    
	    
	    
	
		
	}
}
