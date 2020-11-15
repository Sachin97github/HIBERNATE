package com.nit.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;

import com.nit.utills.OracleHibernateUtil;

/*CREATE OR REPLACE FUNCTION GET_POLICY_INFO_BY_ID
(
  P_ID IN NUMBER,
  P_NAME OUT VARCHAR2,
  P_LOCATION OUT VARCHAR2
)
RETURN VARCHAR2
AS 
 COMPANY_NAME VARCHAR2(20);
BEGIN
  SELECT POLICYNAME,LOCATION,TYPE INTO P_NAME,P_LOCATION,COMPANY_NAME FROM INSURANCEPOLICY WHERE ID=P_ID;
  RETURN company_name;
END;
*/

public class PolicyFunctionCallDAO {

	public String[] getPolicyInfoById(Integer id) {
		Session ses = null;
		Transaction tx=null;
		ses = OracleHibernateUtil.getSession();
		
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();

		String[] outputs = ses.doReturningWork(new ReturningWork<String[]>() {
			@Override
			public String[] execute(Connection con) throws SQLException {
				String[] outputs = new String[3];

				CallableStatement cs = null;
				cs = con.prepareCall("{?= call GET_POLICY_INFO_BY_ID(?,?,?)}");
				// Return Type
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
              
				System.out.println("outSide ");
				// In Parameter
				cs.setInt(2, 23);
				cs.execute();
					System.out.println("INSIDE CS EXECUTION");
					outputs[0] = cs.getString(3);
					outputs[1] = cs.getString(4);
					// Return Type
					outputs[2] = cs.getString(1);
				return outputs;
			}

		});
		return outputs;
	}

}
