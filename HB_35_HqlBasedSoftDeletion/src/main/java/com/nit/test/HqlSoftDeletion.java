package com.nit.test;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.utills.OracleHibernateUtil;

public class HqlSoftDeletion{

	public static void main(String[] args) {
		
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=null;
		Boolean flag=false;
	    int count=0;
	  try
	  {
	      if(!ses.getTransaction().isActive())
		        tx=ses.beginTransaction();
		
	      Query query=ses.createQuery("update BankAccount set status = 'closed' where account=:acno");
	      query.setParameter("acno",71l);
	      
	      count=query.executeUpdate();
	      System.out.println(count);
	      flag=true;
	      
	    		} catch (HibernateException ex) {
	    			flag = false;
	    			ex.printStackTrace();
	    		} catch (Exception ex) {
	    			flag = false;
	    			ex.printStackTrace();
	    		} finally {
	    			if (flag == true) {
	    				tx.commit();
	    				System.out.println("Accounts Marked");
	    			} else {
	    				tx.rollback();
	    				System.out.println("Accounts not marked ");
	    			}
	    		}
	  

		
	}
}
