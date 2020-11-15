package com.nit.test;

import java.util.Date;

import com.nit.dao.IStudentDAO;
import com.nit.dao.StudentDAOImpl;
import com.nit.entity.Course;
import com.nit.entity.Student;

public class DeleteTest {
	public static void main(String[] args) {
	
		IStudentDAO dao=new StudentDAOImpl();
		Student std=new Student();
		// if we doesnot load the object before  deletion than it wont cause any error 
	//	dao.deleteStudent(61);
		//When cascade "all" this Will give Integrity Costant error
		dao.deleteStudentAfterLoading(103);
	}

}
