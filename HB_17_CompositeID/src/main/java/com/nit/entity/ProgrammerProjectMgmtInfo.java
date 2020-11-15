package com.nit.entity;

import java.io.Serializable;

public class ProgrammerProjectMgmtInfo implements Serializable {

	private ProgrammerProjectMgmtId id;
	private String pName;
	private String projName;
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
