package com.nit.entity;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class Address {
	@Type(type="int")
	private int houseno;
	@Type(type="string")
	private String city;
	@Type(type="string")
	private String district;
	@Type(type="string")
	private String state;
	@Type(type="string")
	private String country;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getHouseno() {
		return houseno;
	}
	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [houseno=" + houseno + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", country=" + country + "]";
	}
	
	
}
