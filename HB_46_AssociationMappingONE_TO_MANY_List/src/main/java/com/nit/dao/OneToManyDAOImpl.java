package com.nit.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nit.entity.Person;
import com.nit.entity.PhoneNumber;

public class OneToManyDAOImpl implements OneToManyDAO {

	private Session ses = null;

	public OneToManyDAOImpl(Session ses) {
		this.ses = ses;
	}
	
	@Override
	public void dataInsertion() {
		
	}

	@Override
	public void deletePerson() {
		
	}

}
