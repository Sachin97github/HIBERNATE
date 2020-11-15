package com.nit.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name="PERSON_INFO2")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="Int")
	private Integer pId;

	@Column(name="NAME",length=20)
	@Type(type="string")
	private String pName;
	
	@Temporal(TemporalType.DATE)
	private LocalDate birthDate;
	@Temporal(TemporalType.TIME)
	private LocalDateTime regDate;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalTime preDate;
	@Version
	private Integer versionCount;
	
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalTime getPreDate() {
		return preDate;
	}
	public void setPreDate(LocalTime preDate) {
		this.preDate = preDate;
	}
	public Integer getVersionCount() {
		return versionCount;
	}
	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}
	
	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", birthDate=" + birthDate + ", regDate=" + regDate
				+ ", preDate=" + preDate + ", versionCount=" + versionCount + "]";
	}
	
	
	
	

}
