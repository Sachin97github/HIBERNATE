package com.nit.dao;

import java.util.List;

import com.nit.entity.InsurancePolicy;

public interface PolicyDAO {
	
	public long  getAllRecords();
	public List<InsurancePolicy> getRecordPage(int pos,int pageSize);
	
}
