package com.nt.service;

import java.util.List;

import com.nit.dto.InsurancePolicyDTO;

public interface PolicyService {
	public long getPagesCount(int pageSize);
	public List<InsurancePolicyDTO> getPageData(int pageNo,int pageSize);
}
