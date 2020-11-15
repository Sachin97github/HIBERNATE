package com.nit.test;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.utills.OracleHibernateUtil;

public class HB_filterTest {
	
	public static void main(String[] args) {
		
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=ses.beginTransaction();
		
		Filter filter=ses.enableFilter("ONLY_SPECIFIC_LOCATIONS");
		filter.setParameter("location1","BPL");
		filter.setParameter("location2","HYD");
		//Filter Enabled
		Query query = ses.createQuery("FROM  com.nit.entity.InsurancePolicy");
        query.getResultList().forEach(System.out::println);
        
      //Filter Disabled
        ses.disableFilter("ONLY_SPECIFIC_LOCATIONS");
       Query query1 = ses.createQuery("FROM  com.nit.entity.InsurancePolicy");
       query1.getResultList().forEach(System.out::println);
}

}
