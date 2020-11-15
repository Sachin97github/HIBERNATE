package com.nit.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class PhoneNumber {

	private Integer regNo;
	private Long number;
	private String provider;
	private String  numberType;
	
}
