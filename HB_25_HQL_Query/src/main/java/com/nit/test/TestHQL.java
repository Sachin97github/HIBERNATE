package com.nit.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.dao.InsurancePolicyDAO;
import com.nit.utills.OracleHibernateUtil;

public class TestHQL {
	public static void main(String[] args) {
		InsurancePolicyDAO dao = new InsurancePolicyDAO();
		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		try {

			// dao.getAllPolicy().forEach(System.out::println);
			// dao.getAllPolicy("BPL").forEach(System.out::println);
			// dao.getAllPolicy("BPL","HYD").forEach(System.out::println);
			// dao.getPolicyByName("L").forEach(System.out::println);

			List<Object[]> list = dao.getPolicyInfo("BPL");

			for (Object[] obj : list) {
				System.out.println(obj[0] + " " + obj[1] + " " + obj[2]);
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
