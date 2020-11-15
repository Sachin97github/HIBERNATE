package com.nit.dao;

import javax.persistence.ParameterMode;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION 
(
  UNAME IN VARCHAR2 
, PWORD IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
  CNT  NUMBER(5);
BEGIN
  SELECT COUNT(*) INTO CNT FROM USERDETAILS  WHERE USERNAME=UNAME AND PASSWORD=PWORD;
  IF(CNT<>0) THEN
    RESULT:='VALID CREDENTIALS';
   ELSE
    RESULT:='INVALID CREDENTIALS';
  END IF;  
END P_AUTHENTICATION;*/

import com.nit.utills.OracleHibernateUtil;


public class UserAuthenticationDAO {
	

	public String authenticate(String uname,String pword)
	{
		Session ses=null;
		ProcedureCall call=null;
		Transaction tx=null;
		
		ses=OracleHibernateUtil.getSession();
		if(!ses.getTransaction().isActive())
		     tx=ses.beginTransaction(); 
        call=ses.createStoredProcedureCall("P_AUTHENTICATION");
		call.registerParameter(1,String.class,ParameterMode.IN).bindValue(uname);
		call.registerParameter(2,String.class,ParameterMode.IN).bindValue(pword);
        call.registerParameter(3,String.class,ParameterMode.OUT);	
        
		return (String)call.getOutputParameterValue(3);
	}

}
