package com.nit.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class JPAQBC_UpdateQuery {

	 public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		try {
			ses = OracleHibernateUtil.getSession();
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

		   CriteriaBuilder builder=ses.getCriteriaBuilder();
		   CriteriaUpdate<InsurancePolicy> ctUpdate=builder.createCriteriaUpdate(InsurancePolicy.class);	
		   
		   Root<InsurancePolicy> root=ctUpdate.from(InsurancePolicy.class);
		   
		   ctUpdate.set(root.get("company"),"NEW APEX")
		                      .set(root.get("location"),"NEW BPL")
		                      .where(builder.and(builder.ge(root.get("id"),21),builder.le(root.get("id"),24)));
		   
		   Query<Integer> query=ses.createQuery(ctUpdate);
		   
		   System.out.println(query.executeUpdate());
		   

		} // end of Try
		catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // End of Main

}
