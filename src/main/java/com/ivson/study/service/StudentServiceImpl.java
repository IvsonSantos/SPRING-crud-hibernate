package com.ivson.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivson.study.model.Student;
import com.ivson.study.repository.StudentRepository;
import com.ivson.study.service.exceptions.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student retrieveStudent(long id) {
		
		Optional<Student> student = studentRepository.findById(id);

		if (!student.isPresent())
			throw new StudentNotFoundException("id-" + id);

		return student.get();
	}
	
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}
}
