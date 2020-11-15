package com.nit.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.ResultSetOutput;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

/*CREATE OR REPLACE PROCEDURE P_POLICY_DETAILS_BY_ID
(
     MIN IN  NUMBER,
     MAX IN NUMBER,
     DETAILS OUT SYS_REFCURSOR
)
AS
BEGIN 
  OPEN DETAILS FOR 
    SELECT  ID,POLICYNAME,COMPANY,TYPE,LOCATION FROM INSURANCEPOLICY WHERE ID>=MIN AND ID<=MAX;
END;*/

public class InsurancePolicyDAO {

	public List<Object> getPolicyById(int min, int max) {
		List<Object> list = null;
	//	public List<InsurancePolicy> getPolicyById(int min, int max) {
		//List<InsurancePolicy> list = null;
		Session ses = null;
		Transaction tx = null;
		ProcedureCall call = null;
		// Output op=null;
		ResultSetOutput rs = null;

		ses = OracleHibernateUtil.getSession();
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		call = ses.createStoredProcedureCall("P_POLICY_DETAILS_BY_ID",InsurancePolicy.class);
		//call = ses.createStoredProcedureCall("P_POLICY_DETAILS_BY_ID",InsurancePolicy.class);
		call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(min);
		call.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(max);
		//call.registerParameter(3,InsurancePolicy.class, ParameterMode.REF_CURSOR);
		call.registerParameter(3,Object.class, ParameterMode.REF_CURSOR);

		/*
		 * op=call.getOutputs().getCurrent(); rs=(ResultSetOutput) op;
		 */

		rs = (ResultSetOutput) call.getOutputs().getCurrent();
		list = rs.getResultList();

		return list;

	}

}
