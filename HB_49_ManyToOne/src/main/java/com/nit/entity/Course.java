package com.nit.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Course {
	
	private  Integer Id;
	private String Name;
	private String faculty;
	private Date startDate;
	private Double price;
		

}
