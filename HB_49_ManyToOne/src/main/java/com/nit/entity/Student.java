package com.nit.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {

	private Integer id;
	private String name;
    private String email;
    private Long contact;
    private String address;
    private Course course;
    
    
    
}
