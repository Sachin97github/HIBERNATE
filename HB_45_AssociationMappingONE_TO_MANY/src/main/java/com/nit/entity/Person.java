package com.nit.entity;

import java.util.Set;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@RequiredArgsConstructor
@ToString
public class Person {
	
	private Integer Id;
	private String name;
	private String gender;
	private String address;
	private Set<PhoneNumber> phones;
	
	
	
	

}
