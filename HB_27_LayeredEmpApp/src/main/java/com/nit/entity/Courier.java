package com.nit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COURIER_TAB")
public class Courier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COURIER_ID")
	// @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String destination;
	private String source;
	private String company;

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

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Courier [id=" + id + ", name=" + name + ", destination=" + destination + ", source=" + source
				+ ", company=" + company + "]";
	}

}
