package com.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.dao.OneToManyDAO;
import com.nit.dao.OneToManyDAOImpl;
import com.nit.entity.PhoneNumber;
import com.nit.utills.OracleHibernateUtil;

public class removeAllPhoneNumberToPerson {
	public static void main(String[] args) {
		Session ses=OracleHibernateUtil.getSession();
		OneToManyDAO dao=new OneToManyDAOImpl(ses);
	    Transaction tx=null;
	    Boolean flag=false;
	    try
	    {
	    	if(!ses.getTransaction().isActive())
	    	          tx=ses.beginTransaction();
	    	    dao.removeAllChildsToParent(2);
	    	flag=true;
	    }
	    catch(Exception ex)
	    {
	      ex.printStackTrace();
	  
	    }
		finally
		{
			if(flag)
			{
				tx.commit();
				System.out.println("-------------------Success---------------");
			}
			else
			{
				tx.rollback();
			    System.out.println("-----------------------Problem Occured--------------------------");
			}
		}
		
	}

}
