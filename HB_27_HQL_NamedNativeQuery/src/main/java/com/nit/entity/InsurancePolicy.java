package com.nit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="INSURANCEPOLICY")
@NamedNativeQuery( name="GET_POLICIES_BY_LOCATION",
                                                query="   SELECT ID,NAME,COMPANY,TYPE FROM INSURANCEPOLICY WHERE LOCATION=? "
                                                )
@NamedNativeQuery(name="GET_POLICIES",
                                               query="SELECT * FROM INSURANCEPOLICY",
                                               resultClass=InsurancePolicy.class
                                               )
public class InsurancePolicy {
 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;

	private String name;
	private String type;
	private String company;
	private String location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [id=" + id + ", name=" + name + ", type=" + type + ", company=" + company
				+ ", location=" + location + "]";
	}

}
