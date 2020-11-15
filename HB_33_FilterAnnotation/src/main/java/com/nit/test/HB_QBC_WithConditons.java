package com.nit.test;



import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class HB_QBC_WithConditons {
	
	public static void main(String[] args) {
		
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=ses.beginTransaction();
		
		Filter filter=ses.enableFilter("GET_ONLY_SPECIFIC_LOCATIONS");
		filter.setParameter("location1","BPL");
		filter.setParameter("location2","HYD");

		//CriteriaBuilder builder =ses.getCriteriaBuilder();
		Criteria criteria=ses.createCriteria(InsurancePolicy.class);
        criteria.list().forEach(System.out::println);
		
       //Filter Disabled
        ses.disableFilter("GET_ONLY_SPECIFIC_LOCATIONS");
        criteria.list().forEach(System.out::println);
}

}
