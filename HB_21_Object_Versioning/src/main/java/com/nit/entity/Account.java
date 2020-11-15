package com.nit.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer acno;
	
	@Column(length=20)
	@Type(type="string")
	private  String holderName;
	private  Double  balance;
	@Column(length=20)
	@Type(type="string")
	private String  type;
	
	@CreationTimestamp
	private  LocalDateTime  openingDate; 
	
	@UpdateTimestamp
	private  Date lastUpdated;
	
	//In annotation we can use Both --Timestamp and versioning
	@Version
	Integer versionCount;

	public Integer getAcno() {
		return acno;
	}

	public void setAcno(Integer acno) {
		this.acno = acno;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDateTime openingDate) {
		this.openingDate = openingDate;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	@Override
	public String toString() {
		return "Account [acno=" + acno + ", holderName=" + holderName + ", balance=" + balance + ", type=" + type
				+ ", openingDate=" + openingDate + ", lastUpdated=" + lastUpdated + ", versionCount=" + versionCount
				+ "]";
	}
	
	
	
}

