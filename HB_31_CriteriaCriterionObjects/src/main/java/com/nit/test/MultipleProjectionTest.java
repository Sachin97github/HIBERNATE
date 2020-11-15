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

public class MultipleProjectionTest {
	
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
			//Fetch  columns company  and Id 
			 Projection ps=Projections.property("company");
			 Projection ps1=Projections.property("id");
			 
			 ProjectionList plist=Projections.projectionList();
			 plist.add(ps);plist.add(ps1);
			 
			 criteria.setProjection(ps);
			 //Where Id=25
			 Criterion cond=Restrictions.eq("id",25);
			 criteria.add(cond);
			 List<Object[]> list=criteria.list();
			 
			 list.forEach(row->{
				  System.out.println(row[0]+"..........."+row[1]);
			 });
			 			
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
