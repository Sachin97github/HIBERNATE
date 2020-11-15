package com.nit.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class JPAQBC_AggregateFunction {

	 public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		try {
			ses = OracleHibernateUtil.getSession();
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

		   CriteriaBuilder builder=ses.getCriteriaBuilder();
		   CriteriaQuery<Long> ctQuery=builder.createQuery(Long.class);
		   
		   Root<InsurancePolicy> root=ctQuery.from(InsurancePolicy.class);
		   
		   ctQuery.multiselect(builder.count(root.get("id")));
		   
		   Query <Long> query=ses.createQuery(ctQuery);
		   
		 System.out.println(  query.uniqueResult());
			

		} // end of Try
		catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // End of Main

}
