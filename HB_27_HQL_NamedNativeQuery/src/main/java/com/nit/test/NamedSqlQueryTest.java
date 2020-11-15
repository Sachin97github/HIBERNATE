package com.nit.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class NamedSqlQueryTest {
	public static void main(String[] args) {
		Session ses = OracleHibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		try {
/*
			NativeQuery query = ses.getNamedNativeQuery("GET_POLICIES_BY_LOCATION");
			query.setParameter(1, "HYD");
            List<Object[]> list = query.getResultList();
            
                  list.forEach(row -> {
				for (Object obj : row)
					System.out.println(obj + " , ");
			});
			*/                                                                                                      
            List<InsurancePolicy> list=ses.getNamedNativeQuery("GET_POLICIES").getResultList();
			list.forEach(System.out::println);
		tx.commit();
		}

		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
