package com.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class InsertingData {
	public static void main(String[] args) {

		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=ses.beginTransaction();
	try
	{
		for(int i=0;i<4;i++)
		{
			InsurancePolicy policy=new InsurancePolicy();
			policy.setName("B4");
			policy.setCompany("TATA");
			policy.setType("ACCIDENTAL");
			policy.setLocation("DLH");
			
			Integer id=(Integer) ses.save(policy);
			System.out.println("Generated ID"+id);
			}
		tx.commit();

	}
	catch(Exception e)
	{
		tx.rollback();
		e.printStackTrace();
	}
	}
		
}
