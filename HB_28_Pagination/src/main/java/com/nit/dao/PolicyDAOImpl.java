package com.nit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.InsurancePolicy;
import com.nit.utills.OracleHibernateUtil;

public class PolicyDAOImpl implements PolicyDAO {

	private Session ses=null;
	private Transaction tx=null;
	
	public PolicyDAOImpl() {
		ses=OracleHibernateUtil.getSession();
		tx=ses.beginTransaction();
	}

	@Override
	public long  getAllRecords() {
	List<Long> list=ses.getNamedQuery("GET_POLICIES_COUNT").getResultList();
	return list.get(0);
	}

	@Override
	public List<InsurancePolicy> getRecordPage(int position, int pageSize) {
		   
		return ses.getNamedQuery("GET_ALL_POLICIES")
	  			            .setFirstResult(position)
	  			            .setMaxResults(pageSize)
	  			            .getResultList();
	}

}
