package com.nit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class ProgrammerProjectMgmtId  implements Serializable{

	@Column(name="PID")
	@Type(type="int")
	private Integer pId;
	
	@Column(name="PROJID")
	@Type(type="int")
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
