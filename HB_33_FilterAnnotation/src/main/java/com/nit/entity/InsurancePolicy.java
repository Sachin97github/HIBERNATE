package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="INSURANCEPOLICY")
@Filter( name="GET_ONLY_SPECIFIC_LOCATIONS",
                  condition="LOCATION IN(:location1,:location2)"
               )
@FilterDef(name="GET_ONLY_SPECIFIC_LOCATIONS",
                       parameters={  @ParamDef(name="location1" , type="string") ,
                                                    @ParamDef(name="location2" , type="string")
                                                 } )
public class InsurancePolicy {
 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="POLICYNAME",length=20)
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
