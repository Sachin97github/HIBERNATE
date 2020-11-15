package com.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.dao.OneToManyDAO;
import com.nit.dao.OneToManyDAOImpl;
import com.nit.utills.OracleHibernateUtil;

public class DataFetchTest {
	public static void main(String[] args) {
		Session ses=OracleHibernateUtil.getSession();
		OneToManyDAO dao=new OneToManyDAOImpl(ses);
	    Transaction tx=null;
	    Boolean flag=false;
	    try
	    {
	    	if(!ses.getTransaction().isActive())
	    	          tx=ses.beginTransaction();
	      
	    	//dao.getPerson(2);
	    	dao.deletePerson(3);  //it makes Child Table Record Oraphan 
	    	 // FK as Null (Orphan)
	    
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
