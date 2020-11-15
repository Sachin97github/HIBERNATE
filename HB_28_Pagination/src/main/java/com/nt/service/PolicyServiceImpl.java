package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nit.dao.PolicyDAO;
import com.nit.dao.PolicyDAOImpl;
import com.nit.dto.InsurancePolicyDTO;
import com.nit.entity.InsurancePolicy;

public class PolicyServiceImpl implements PolicyService {

	private PolicyDAO dao = new PolicyDAOImpl();

	@Override
	public long  getPagesCount(int pageSize) {
		int records=(int) dao.getAllRecords();
		int pagesCount=records/pageSize;
		if(records%pageSize!=0)
		             pagesCount++;
		return pagesCount;
	}

	@Override
	public List<InsurancePolicyDTO> getPageData(int pageNo, int pageSize) {
		
		List<InsurancePolicy> entities = null;
		List<InsurancePolicyDTO> dtos = new ArrayList();
	                                     //  2      *    4 = 8  //8-4 = 4 start from 4
		int firstResult=(pageNo*pageSize)-pageSize;
		int maxResult=pageSize;
  
		
	     	entities = dao.getRecordPage(firstResult,maxResult);
	    	entities.forEach(entity -> {
			InsurancePolicyDTO dto = new InsurancePolicyDTO();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setType(entity.getType());
			dto.setCompany(entity.getCompany());
			dto.setLocation(entity.getLocation());
            dtos.add(dto);
		});

		return dtos;
	}

}
