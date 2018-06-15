package com.ivson.study.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ivson.study.model.Student;

public interface StudentService {

	public List<Student> retrieveAllStudents();
	
	public Student retrieveStudent(long id);
	
	public void deleteStudent(long id);
	
	public ResponseEntity<Object> createStudent(Student student);
	
	public ResponseEntity<Object> updateStudent(Student student, long id);

}