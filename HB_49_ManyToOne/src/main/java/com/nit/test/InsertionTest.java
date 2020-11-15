package com.nit.test;

import java.util.Date;

import com.nit.dao.IStudentDAO;
import com.nit.dao.StudentDAOImpl;
import com.nit.entity.Course;
import com.nit.entity.Student;

public class InsertionTest {
	public static void main(String[] args) {
	
		IStudentDAO dao=new StudentDAOImpl();
		
		
		Course course=new Course();
		course.setName("Hibernate");
		course.setFaculty("Mr Natraz");
		course.setPrice(4500d);
		course.setStartDate(new Date(12,01,2020));
		
		
	
		Student std=new Student();
		std.setName("Ashish");
		std.setEmail("nitin7697@yahoo.com");
		std.setContact(7697019105l);
		std.setAddress("BPL");
		std.setCourse(course);
		/*
		 * firmware vender system
		 */
		
		Student std1=new Student();
		std1.setName("Ashish");
		std1.setEmail("nitin7697@yahoo.com");
		std1.setContact(7697019105l);
		std1.setAddress("BPL");
		std1.setCourse(course);
		
		Student std2=new Student();
		std2.setName("Ashish");
		std2.setEmail("nitin7697@yahoo.com");
		std2.setContact(7697019105l);
		std2.setAddress("BPL");
		std2.setCourse(course);
		
		dao.addStudent(std);
		dao.addStudent(std1);
		dao.addStudent(std2);
		
	}

}
