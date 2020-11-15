package com.nit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PERSON_INFO2")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="int")
	private Integer pId;
	
	@Column(name="NAME",length=20)
	@Type(type="string")
	private String pName;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	@Temporal(TemporalType.TIME)
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
