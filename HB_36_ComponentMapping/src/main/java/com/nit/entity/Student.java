package com.nit.entity;

import java.io.Serializable;

public class Student implements Serializable {
	
	private Integer sno;
	private String sname;
	private String email;
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
