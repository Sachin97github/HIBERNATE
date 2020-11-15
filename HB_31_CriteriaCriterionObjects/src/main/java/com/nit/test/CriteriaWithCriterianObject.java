package com.nit.test;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class CriteriaWithCriterianObject {
	
	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		
		try
		{
			ses=OracleHibernateUtil.getSession();
			
			if(!ses.getTransaction().isActive())
	            tx=ses.beginTransaction();
				
			Criteria criteria=ses.createCriteria(InsurancePolicy.class);
			//Critetion Obj to put some Condtitions
			
			//Criterion cond=Restrictions.in("type","LIFETIME","ACCIDENTAL");
			//Criterion cond=Restrictions.in("type","LIFETIME");
			
		   //Criterion cond=Restrictions.like("type","%E");
			//Criterion cond=Restrictions.between("id",21,26);
			//Criterion cond=Restrictions.eq("id",26);
			
			//============AND clause============
			/*Criterion cond=Restrictions.eq("id",26);
			Criterion cond2=Restrictions.eq("name","APEX");
			 Criterion cond3=Restrictions.and(cond,cond2);
			criteria.add(cond3).list().forEach(System.out::println);*/
			
			/*Criterion cond=Restrictions.sqlRestriction("rowNum>=? and rowNum<=?",
					                                                                               new Object[]{2,5},
					                                                                               new Type[]{StandardBasicTypes.INTEGER,
					                                                                            		                    StandardBasicTypes.INTEGER});*/
		//	criteria.add(cond).list().forEach(System.out::println);
			
		
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
