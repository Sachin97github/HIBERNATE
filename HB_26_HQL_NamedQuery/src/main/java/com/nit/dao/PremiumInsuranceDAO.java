package com.nit.dao;

import java.util.Optional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.utills.OracleHibernateUtil;

public class PremiumInsuranceDAO {

	Session ses = OracleHibernateUtil.getSession();
	Transaction tx = ses.beginTransaction();

	public void getName(Integer id) {
		try {

			Query query = ses.createNamedQuery("GET_NAME2");
			query.setParameter("id",id);
			Optional<String> opt = query.uniqueResultOptional();

			System.out.println("GET_NAME namedQuery");
			System.out.println("Result " + opt.orElse("No Record"));

		}

		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public void getLocation(Integer id) {

		try {

			Query query = ses.createNamedQuery("GET_LOCATION2");
			query.setParameter("id",id);
			Optional<String> opt = query.uniqueResultOptional();

			System.out.println("GET_LOCATION namedQuery");
			System.out.println("Result " + opt.orElse("No Record"));

		}

		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
