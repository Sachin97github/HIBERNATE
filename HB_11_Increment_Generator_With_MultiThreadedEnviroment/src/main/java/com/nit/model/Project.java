package com.nit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;


public class Project implements Serializable {

	private Long proID;
	private String pName;
	private String pCompony;
	private String pDuration;
	public Long getProID() {
		return proID;
	}
	public void setProID(Long proID) {
		this.proID = proID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCompony() {
		return pCompony;
	}
	public void setpCompony(String pCompony) {
		this.pCompony = pCompony;
	}
	public String getpDuration() {
		return pDuration;
	}
	public void setpDuration(String pDuration) {
		this.pDuration = pDuration;
	}
	@Override
	public String toString() {
		return "Project [proID=" + proID + ", pName=" + pName + ", pCompony=" + pCompony + ", pDuration=" + pDuration
				+ "]";
	}
	
	
	

}
