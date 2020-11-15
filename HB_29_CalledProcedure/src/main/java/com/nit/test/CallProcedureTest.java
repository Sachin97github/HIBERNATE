package com.nit.test;

import com.nit.dao.UserAuthenticationDAO;

public class CallProcedureTest {

	public static void main(String[] args) {

		UserAuthenticationDAO dao = new UserAuthenticationDAO();

		System.out.println(dao.authenticate("SACHCHU2", "12345"));

	}

}
