package com.nit.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class InsurancePolicyDAO {
	
	Session ses=OracleHibernateUtil.getSession();
	//HQL Select Query
	public List<InsurancePolicy> getAllPolicy()
	{
		String str="FROM InsurancePolicy";
		Query  query=ses.createQuery(str);
     	List<InsurancePolicy> list=query.getResultList();
		//List<InsurancePolicy> list=query.list();
     	return list;	
	}
	public List<InsurancePolicy> getAllPolicy(String location)
	{
		String str="FROM InsurancePolicy WHERE location=?2";
		Query  query=ses.createQuery(str);
		query.setParameter(2,location);
     	List<InsurancePolicy> list=query.getResultList();
		//List<InsurancePolicy> list=query.list();
     	return list;	
	}
	
	public List<InsurancePolicy> getAllPolicy(String location1,String location2)
	{
		//Can start with any Number But Sequnce Should be there 
		String str="FROM InsurancePolicy WHERE location IN(?2,?3)";
		Query  query=ses.createQuery(str);
		query.setParameter(2,location1);
		query.setParameter(3,location2);
     	List<InsurancePolicy> list=query.getResultList();
		//List<InsurancePolicy> list=query.list();
     	return list;	
	}
	
	
	public List<InsurancePolicy> getPolicyByName(String letter)
	{
		//Can start with any Number But Sequnce Should be there 
		String str="FROM InsurancePolicy WHERE name like  %:letter%";
		Query  query=ses.createQuery(str);
        query.setParameter("letter",letter);
     	List<InsurancePolicy> list=query.getResultList();
		//List<InsurancePolicy> list=query.list();
     	return list;	
	}

	//Scaler Query
	/* public List<Object[]> getPolicyInfo(String location)
	 {
		Query qry=ses.createQuery("SELECT id,name,location,type FROM InsurancePolicy where location = :location");
		qry.setParameter("location",location);
		return qry.getResultList();		 
	 }*/
	 
	 public List<Object[]> getPolicyInfo(String location)
	 {	
		return ses.createQuery("SELECT id,name,location,type FROM InsurancePolicy where location = :location")
				.setParameter("location",location)
				.getResultList();
     }
	
	 
	 

  
	
	
	
}
