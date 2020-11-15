package com.nit.test;

import java.util.Date;

import com.nit.dao.IStudentDAO;
import com.nit.dao.StudentDAOImpl;
import com.nit.entity.Course;
import com.nit.entity.Student;

public class FetchAllStudent {
	public static void main(String[] args) {
	
		IStudentDAO dao=new StudentDAOImpl();
		dao.getAllStudent();		
	}

}
