package com.nit.test;

import java.util.Arrays;

import com.nit.dao.PolicyFunctionCallDAO;
 
public class FunctionTest {
	public static void main(String[] args) {
		
   PolicyFunctionCallDAO dao=new PolicyFunctionCallDAO();
   System.out.println(Arrays.toString(dao.getPolicyInfoById(23)));		
	}

}
