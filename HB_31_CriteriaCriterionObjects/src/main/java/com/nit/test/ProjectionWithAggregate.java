package com.nit.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class ProjectionWithAggregate {
	
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
		    
			//Projection ps=Projections.rowCount();
			Projection ps=Projections.max("id");
		    criteria.setProjection(ps);
		   
		    Object result=criteria.uniqueResult();
		    System.out.println(result);

		    
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
