package com.nit.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

/*@Entity
@Table(name="PERSON_INFO")*/
@Data
public class Person {
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.SEQUENCE)
	 */
	private Integer Id;
	private String name;
	private String gender;
	private String address;
	
	/*
	 * @ElementCollection
	 * 
	 * @Column(name="PHONE")
	 * 
	 * @CollectionTable(name="PHONES", joinColumns=@JoinColumn(name="PERSON_ID" ,
	 * referencedColumnName="id"))
	 * 
	 * @ListIndexBase(value=1)
	 * 
	 * @OrderColumn(name="PHONEINDEX")
	 */
	private Set<String> phones;
	
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name="FRIENDS",
	 * joinColumns=@JoinColumn(name="PERSON_ID",referencedColumnName="id"))
	 * 
	 * @Column(name="FRIEND") //@ListIndexBase(value=1)
	 * //@OrderColumn(name="FRIENDNO")
	 */	private List<String> friends;
	
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name="FAMILY",
	 * joinColumns=@JoinColumn(name="PERSON_ID",referencedColumnName="id"))
	 * 
	 * @MapKeyColumn(name="RELATION")
	 * 
	 * @Column(name="NAME")
	 */
	private Map<String,String> family;
	
	
	

}
