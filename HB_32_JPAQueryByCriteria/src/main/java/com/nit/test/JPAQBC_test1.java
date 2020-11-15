package com.nit.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class JPAQBC_test1 {

	// Projections arre Used for Scalar Operations
	// Fetching Specificc One Or more Column

	public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		try {
			ses = OracleHibernateUtil.getSession();
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

			CriteriaBuilder builder = ses.getCriteriaBuilder();
			// Query Based On
			CriteriaQuery<InsurancePolicy> ctQuery = builder.createQuery(InsurancePolicy.class);
			// Resultant <EntityClass> Object
			Root<InsurancePolicy> root = ctQuery.from(InsurancePolicy.class);

			ctQuery.select(root);

			Query<InsurancePolicy> query = ses.createQuery(ctQuery);

			List<InsurancePolicy> list = query.getResultList();

			list.forEach(System.out::println);

		} // end of Try
		catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // End of Main

}
