package com.nit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PROGRAMMER_PROJECT_INFO")
public class ProgrammerProjectMgmtInfo implements Serializable {
	@EmbeddedId
	private ProgrammerProjectMgmtId id;
 
	@Column(name="PNAME",length=20)
	@Type(type="string")
	//Can not give  "String" it will cause error
	private String pName;
	
	@Column(name="PROJNAME",length=20)
	@Type(type="string")
	private String projName;
	
	@Column(name="DEPTNAME",length=20)
	@Type(type="string")
	private String deptName;

	public ProgrammerProjectMgmtId getId() {
		return id;
	}

	public void setId(ProgrammerProjectMgmtId id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "ProgrammerProjectMgmtInfo [id=" + id + ", pName=" + pName + ", projName=" + projName + ", deptName="
				+ deptName + "]";
	}

}
