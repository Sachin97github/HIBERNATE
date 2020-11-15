package com.nit.service;

import com.nit.dao.CourierDAO;
import com.nit.dao.CourierDAOImpl;
import com.nit.dto.CourierDTO;
import com.nit.entity.Courier;

public class CourierServiceImpl implements CourierService {

	private CourierDAO dao = new CourierDAOImpl();

	@Override
	public Integer addCourier(CourierDTO dto) {
		Courier entity = new Courier();

		entity.setName(dto.getName());
		entity.setDestination(dto.getDestination());
		entity.setSource(dto.getSource());
		entity.setCompany(dto.getCompany());

		return dao.addCourier(entity);

	}

}
