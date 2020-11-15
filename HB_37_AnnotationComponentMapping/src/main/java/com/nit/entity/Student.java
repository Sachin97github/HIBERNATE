package com.nit.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="STUDENT_INFO")
@Entity
public class Student implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer sno;
	private String sname;
	private String email;
	@Embedded
	private Address addr;
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", email=" + email + ", addr=" + addr + "]";
	}
	
	

}
