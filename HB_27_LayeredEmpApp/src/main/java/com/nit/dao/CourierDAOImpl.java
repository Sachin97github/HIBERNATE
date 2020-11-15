package com.nit.dao;

import org.hibernate.Session;

import com.nit.entity.Courier;
import com.nit.utills.OracleHibernateUtil;

public class CourierDAOImpl implements CourierDAO {

	 private Session ses=OracleHibernateUtil.getSession();
	 
	@Override
	public Integer addCourier(Courier entity) {
	       return (Integer) ses.save(entity);
	}

}
