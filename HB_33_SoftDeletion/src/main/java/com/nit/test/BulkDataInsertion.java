package com.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.BankAccount;
import com.nit.utills.OracleHibernateUtil;

public class BulkDataInsertion{

	public static void main(String[] args) {
		
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=ses.beginTransaction();
		
	  for(int i=1;i<5;i++)
	  {
		  BankAccount obj=new BankAccount();
	      obj.setUsername("acc"+i);
		  obj.setStatus("active");
		  obj.setBalance(i*Math.random());
		  ses.save(obj);
	  }
	  
	  tx.commit();
	
		
	}
}
