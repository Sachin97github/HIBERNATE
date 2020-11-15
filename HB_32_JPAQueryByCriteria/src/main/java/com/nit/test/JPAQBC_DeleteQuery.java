package com.nit.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class JPAQBC_DeleteQuery {

	 public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		try {
			ses = OracleHibernateUtil.getSession();
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();

		   CriteriaBuilder builder=ses.getCriteriaBuilder();
		   CriteriaDelete<InsurancePolicy> ctDelete=builder.createCriteriaDelete(InsurancePolicy.class);		
		   
		   Root<InsurancePolicy> root=ctDelete.from(InsurancePolicy.class);
		   
		   ctDelete.where(builder.equal(root.get("id"),23));
		   
		   Query<Integer> query=ses.createQuery(ctDelete);
		   
		   System.out.println(query.executeUpdate());
		   

		} // end of Try
		catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	} // End of Main

}
