package com.nit.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.Product;
import com.nit.utills.MysqlHibernateUtil;
import com.nit.utills.OracleHibernateUtil;

public class ProductDao {

	public String getProduct(long id) {
		Session oraSes = null;
		Session mysqlSes = null;
		Transaction tx = null;
		Product p = null;
		boolean flag = false;

		oraSes = OracleHibernateUtil.getSession();
		mysqlSes = MysqlHibernateUtil.getSession();

		//Dummy TTransaction becoz of CONTEXTUAL SESSION OBJECT 
		Transaction tx2=oraSes.beginTransaction();
		
		p = oraSes.get(Product.class, 1l);
		System.out.println(p);
		if (p != null) {
			try {
				tx=mysqlSes.beginTransaction();
				Long IdVal = (Long) mysqlSes.save(p);
				flag = true;
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
			} finally {
				if (flag)
					tx.commit();
				else
					tx.rollback();
			}

		}

		return "Product Fetched And Saved";

	}

}
