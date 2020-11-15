package com.nit.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_TPC")
@PrimaryKeyJoinColumn(name="id")
public class Employee extends Person {

	
	private String desg;
	private String company;
	private Double salary;
	public Employee() {
		super();

	}
	public Employee(String desg, String company, Double salary) {
		super();
		this.desg = desg;
		this.company = company;
		this.salary = salary;
	}
	public String getDesg() {
		return desg;
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return  super.toString()+ "desg=" + desg + ", company=" + company + ", salary=" + salary + "]";
	}
	
	
	
	
}
