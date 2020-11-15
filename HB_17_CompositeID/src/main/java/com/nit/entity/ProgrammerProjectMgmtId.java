package com.nit.entity;

import java.io.Serializable;

public class ProgrammerProjectMgmtId  implements Serializable{

	private Integer pId;
	private Integer  projId;
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	@Override
	public String toString() {
		return "ProgrammerProjectMgmtid [pId=" + pId + ", projId=" + projId + "]";
	}
	
	
	
}
