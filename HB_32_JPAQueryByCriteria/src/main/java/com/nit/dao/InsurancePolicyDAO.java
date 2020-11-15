package com.nit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class InsurancePolicyDAO {

 private Session ses=null;
 private Transaction tx=null;
 
 public List<InsurancePolicy> getPolicyList()
 {
	     ses=OracleHibernateUtil.getSession();
	     if(!ses.getTransaction().isActive())
	    	 tx=ses.beginTransaction();
	     
	  
	 
	 
	 
	  return null;
	  }
	
}
