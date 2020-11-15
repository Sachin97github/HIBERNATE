package com.nit.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class JPAQBC_WithExpression {

	 public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		try {
			ses = OracleHibernateUtil.getSession();
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

			CriteriaBuilder builder = ses.getCriteriaBuilder();
			CriteriaQuery<InsurancePolicy> ctQuery = builder.createQuery(InsurancePolicy.class);
			
			Root<InsurancePolicy> root = ctQuery.from(InsurancePolicy.class);
           // ctQuery.select(root);
           ParameterExpression<Integer> param=builder.parameter(Integer.class);
           ParameterExpression<Integer> param1=builder.parameter(Integer.class);
           
           Predicate pdc=builder.ge(root.get("id"),param);
           Predicate pdc1=builder.le(root.get("id"),param1);
          
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
