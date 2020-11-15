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

public class JPAQBC_ScalarQuery {

	 public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		try {
			ses = OracleHibernateUtil.getSession();
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

			CriteriaBuilder builder = ses.getCriteriaBuilder();
			CriteriaQuery<Object[]> ctQuery = builder.createQuery(Object[].class);
			
			Root<InsurancePolicy> root=ctQuery.from(InsurancePolicy.class);
		/*	Select all row having Only three Coulmn
			ctQuery.multiselect(root.get("id"),root.get("company"),root.get("location"));*/
	   /* where id<=? and id>=?;
	      ctQuery.multiselect(root.get("id"),root.get("company"),root.get("location")).where(builder.and(builder.ge(root.get("id"),21),builder.le(root.get("id"),25)));*/		
			
			ctQuery.multiselect(root.get("id"),root.get("company"),root.get("location")).where(builder.and(builder.like(root.get("company"),"%J")),builder.equal(root.get("id"), 21));
			
			
		    Query<Object[]> query = ses.createQuery(ctQuery);

			List<Object[]> list = query.getResultList();
           
			list.forEach(row->{
			         System.out.println(row[0]+ " , "+row[1]+" , "+row[2]);
			});
			

		} // end of Try
		catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // End of Main

}
