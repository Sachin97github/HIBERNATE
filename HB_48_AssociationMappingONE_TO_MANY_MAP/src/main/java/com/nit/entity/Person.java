package com.nit.entity;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	
	private Integer Id;
	@NonNull
	private String name;
	@NonNull
	private String gender;
	@NonNull
	private String address;
	private Map<String,PhoneNumber> phones;
	
	
	
	

}
