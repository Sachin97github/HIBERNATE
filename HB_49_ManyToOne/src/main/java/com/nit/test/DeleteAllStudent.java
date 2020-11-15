package com.nit.test;

import java.util.Date;

import com.nit.dao.IStudentDAO;
import com.nit.dao.StudentDAOImpl;
import com.nit.entity.Course;
import com.nit.entity.Student;

public class DeleteAllStudent {
	public static void main(String[] args) {
	
		IStudentDAO dao=new StudentDAOImpl();
		Student std=new Student();
	   // dao.deleteAllStudentHQL();
		// if Cascading is none then all Chlid Objs will be deleted not Parent
		dao.deleteAllStudentAfterLoading();
	}

}
