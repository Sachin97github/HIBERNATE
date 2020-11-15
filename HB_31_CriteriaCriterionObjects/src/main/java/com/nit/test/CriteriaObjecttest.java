package com.nit.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class CriteriaObjecttest {
	
	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		
		try
		{
			ses=OracleHibernateUtil.getSession();
			
			if(!ses.getTransaction().isActive())
	            tx=ses.beginTransaction();
				
			Criteria criteria=ses.createCriteria(InsurancePolicy.class);
			
			List<InsurancePolicy>  list=criteria.list();
			
			list.forEach(System.out::println);
		}// end of Try
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
} // End of Main
	

}
