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

public class JPAQBC_MethodChaining {

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
         
			//Select Insurance Policy where id>= ?
			//ctQuery.select(root).where(builder.ge(root.get("id"),21));
			
			// select from InsurancePolicy  where id>=21 and id<=30
		   //	ctQuery.select(root).where(builder.and(builder.ge(root.get("id"),21)),builder.le(root.get("id"), 30));
			
			//ctQuery.select(root).where(builder.between(root.get("id"), 21, 30));
			
		//	ctQuery.select(root).where(builder.in(root.get("id").in(21,23,25)));
			
			ctQuery.select(root).where(builder.in(root.get("id").in(21,23,24))).orderBy(builder.asc(root.get("name")));
			
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
