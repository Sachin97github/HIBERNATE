package com.nit.test;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class JPA_QBC_ConditionFilter{
	
	public static void main(String[] args) {
		
		Session ses=OracleHibernateUtil.getSession();
		Transaction tx=ses.beginTransaction();
		
		Filter filter=ses.enableFilter("GET_ONLY_SPECIFIC_LOCATIONS");
		filter.setParameter("location1","BPL");
		filter.setParameter("location2","HYD");

		CriteriaBuilder builder=ses.getCriteriaBuilder();
		CriteriaQuery ctQuery=builder.createQuery(InsurancePolicy.class);
		Root<InsurancePolicy> root=ctQuery.from(InsurancePolicy.class);
		
		ctQuery.select(root).where(builder.equal(root.get("name"),"LIC"));
		//Filter Enabled
		Query query=ses.createQuery(ctQuery);
		query.getResultList().forEach(System.out :: println);
			
}

}
