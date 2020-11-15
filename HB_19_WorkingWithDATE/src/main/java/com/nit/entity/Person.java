package com.nit.entity;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	private Integer pId;
	private String pName;
	private Date birthDate;
	private Date regDate;
	private Date preDate;
	
	

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getPreDate() {
		return preDate;
	}

	public void setPreDate(Date preDate) {
		this.preDate = preDate;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pId + ", pname=" + pName + ", birthDate=" + birthDate + ", regDate=" + regDate
				+ ", preDate=" + preDate + "]";
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

}
