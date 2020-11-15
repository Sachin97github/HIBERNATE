package com.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.dao.OneToManyDAO;
import com.nit.dao.OneToManyDAOImpl;
import com.nit.entity.PhoneNumber;
import com.nit.utills.OracleHibernateUtil;

public class removeAllPersonTest {
	public static void main(String[] args) {
		Session ses=OracleHibernateUtil.getSession();
		OneToManyDAO dao=new OneToManyDAOImpl(ses);
	    Transaction tx=null;
	    Boolean flag=false;
	    try
	    {
	    	if(!ses.getTransaction().isActive())
	    	          tx=ses.beginTransaction();
	      
	    	//dao.removeAllPersonByHQL();
	    	// HQL will give error
	    	//Error Msg = ORA-02292: integrity constraint (SYSTEM.FKNSSCPTMOY09U0RUU9A18EGVER) violated - child record found
            //dao.deletePerson(2);
	    	
	    	//dao.removeAllPersonOneByOne();
	    	// One by One deletion works because  it make All associated Child Orphan
	    	//By making there FK as Null
	    	
	    	// To OverCome this  Orphan issue  cascade="all-delete-orphan" 
	    	
	    	
	    	
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
