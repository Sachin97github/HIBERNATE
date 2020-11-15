package com.nit.dao;

import com.nit.entity.Student;

public interface IStudentDAO {
	
	public void addStudent(Student std);
	public void getAllStudent();
	public void deleteStudent(Integer id);
	public void deleteStudentAfterLoading(Integer id);
	public void deleteAllStudentHQL();
	public void deleteAllStudentAfterLoading();
}
