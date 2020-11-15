package com.nit.test;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.nit.dao.PremiumInsuranceDAO;

public class NamedQueryAnnotationTest {
	
	
	public static void main(String[] args) {

		PremiumInsuranceDAO dao=null;
		dao=new  PremiumInsuranceDAO();
		dao.getName(67);
		System.out.println("==================================");
		dao.getLocation(43);
		
	}

}
