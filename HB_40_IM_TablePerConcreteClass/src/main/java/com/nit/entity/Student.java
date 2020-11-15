package com.nit.entity;

public class Student extends Person {
 
	private String std;
	private String school;
	private int marks;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String std, String school, int marks) {
		super();
		this.std = std;
		this.school = school;
		this.marks = marks;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [std=" + std + ", school=" + school + ", marks=" + marks + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress() + "]";
	}
	
	
	
}
