package com.nit.test;

import org.hibernate.exception.DataException;

import com.nit.dao.ProductDao;

public class TwoDataBAseTest {

	public static void main(String[] args) {
		
	 ProductDao dao=new ProductDao();
		
		try
		{
			System.out.println(dao.getProduct(12323l));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
