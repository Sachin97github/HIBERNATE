package com.nit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

	private Long proID;
	private String pName;
	private String pCompony;
	private String pDuration;
	
	private String transientTest;

	@Id
	@Column(name = "PROID")
	public Long getProID() {
		return proID;
	}

	@Transient
	public String getTransientTest() {
		return transientTest;
	}

	public void setTransientTest(String transientTest) {
		this.transientTest = transientTest;
	}

	public void setProID(Long proID) {
		this.proID = proID;
	}

	//Here if we pass null value  to this feild for Data Persistance it will give Error
	//Because of nullable False
	@Column(name = "PNAME", unique = true, nullable = false)
	//@Column(name = "PNAME")
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@NotNull
	@Column(name = "COMPONYNAME")
	public String getpCompony() {
		return pCompony;
	}

	public void setpCompony(String pCompony) {
		this.pCompony = pCompony;
	}

	@NotNull
	@Column(name = "DURATION")
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
