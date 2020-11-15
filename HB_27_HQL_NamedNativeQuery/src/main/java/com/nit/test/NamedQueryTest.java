package com.nit.test;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.utills.OracleHibernateUtil;

public class NamedQueryTest {
	public static void main(String[] args) {
		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		try {

			Query query = ses.createNamedQuery("GET_LOCATION");
			query.setParameter("idval",21);

			Optional<String> opt = query.uniqueResultOptional();
			if (opt.isPresent())
				System.out.println(opt.get());
			else
				System.out.println("NO record found");

		}

		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
