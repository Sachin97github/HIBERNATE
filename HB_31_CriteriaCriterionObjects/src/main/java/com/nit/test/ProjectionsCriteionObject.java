package com.nit.test;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class ProjectionsCriteionObject {
	
	//Projections arre Used for Scalar Operations 
	 // Fetching Specificc One Or more Column
	
	
	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		
		try
		{
			ses=OracleHibernateUtil.getSession();
			
			if(!ses.getTransaction().isActive())
	            tx=ses.beginTransaction();
				
			Criteria criteria=ses.createCriteria(InsurancePolicy.class);
			// Fetch Only Columns <company> value 
			 Projection ps=Projections.property("company");
			 criteria.setProjection(ps);
			  ///Where ID = 25
			 Criterion cond=Restrictions.eq("id",25);
			 criteria.add(cond).list().forEach(System.out::println);
			 			
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
