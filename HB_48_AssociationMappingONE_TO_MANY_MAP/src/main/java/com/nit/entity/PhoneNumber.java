package com.nit.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class PhoneNumber {

	private Integer regNo;
	@NonNull
	private Long number;
	@NonNull
	private String provider;
	@NonNull
	private String  numberType;
	
	private Integer person_id;
	
}
