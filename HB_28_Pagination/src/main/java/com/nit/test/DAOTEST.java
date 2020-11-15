package com.nit.test;

import com.nt.service.PolicyService;
import com.nt.service.PolicyServiceImpl;

public class DAOTEST {
	public static void main(String[] args) {
		/* PolicyDAOImpl dao= new PolicyDAOImpl();
		System.out.println(dao.getAllRecords());
		dao.getRecordPage(2,4).forEach(System.out::println);*/
		/*
		PolicyService service=new PolicyServiceImpl();
		System.out.println(service.getPolicyCount());
		service.getPolicyPage(2,4).forEach(System.out::println);*/
		PolicyService service=new PolicyServiceImpl();
		
		System.out.println("Pages Count "+service.getPagesCount(4));
		
		service.getPageData(4,4).forEach(System.out::println);
		                           //page No ,, Page Size
		
	}

}
