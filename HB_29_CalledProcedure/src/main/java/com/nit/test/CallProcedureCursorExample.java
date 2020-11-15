package com.nit.test;

import com.nit.dao.InsurancePolicyDAO;

public class CallProcedureCursorExample {

	public static void main(String[] args) {
 
		InsurancePolicyDAO dao=new InsurancePolicyDAO();
		
		dao.getPolicyById(21,25).forEach(System.out::println);

	}

}
