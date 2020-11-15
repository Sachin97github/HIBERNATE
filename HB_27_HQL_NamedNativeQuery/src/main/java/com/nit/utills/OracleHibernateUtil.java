package com.nit.utills;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.nit.dao.PremiumInsuranceDAO;
import com.nit.entity.InsurancePolicy;
import com.nit.entity.PremiumInsurancePolicy;

public class OracleHibernateUtil {
	
	public static SessionFactory  factory=null;
	
	static 
	{
		try{
			     StandardServiceRegistry registry=null;
			     Configuration cfg=new Configuration();
			     cfg.configure("com/nit/cfgs/oracle-hibernate.cfg.xml");
			     //cfg.addResource("com/nit/entity/InsurancePolicy.hbm.xml");
			     cfg.addAnnotatedClass(PremiumInsurancePolicy.class);
			     cfg.addAnnotatedClass(InsurancePolicy.class);
			     
	
			     StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			     
			     registry=builder.applySettings(cfg.getProperties()).build();
			     factory=cfg.buildSessionFactory(registry);			     
			     
		  }
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
	}//static

	public static Session  getSession()
	{
		Session ses=null;
	     if(factory!=null)
	    	  ses=factory.getCurrentSession();
	     else
	    	 System.out.println("Problem while creating Session Factory");
	     return ses;
	     }
	public void closeSessionFactory()
	{
		factory.close();
	}
	
}
