package com.ivson.study.service;

import java.util.List;

import com.ivson.study.model.Student;

public interface StudentService {

	public List<Student> retrieveAllStudents();
	
	public Student retrieveStudent(long id);
	
	public void deleteStudent(long id);
	
}