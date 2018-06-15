package com.ivson.study.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	public ResponseEntity<Object> createStudent(Student student) {
		Student savedStudent = studentRepository.save(student);

		URI location = ServletUriComponentsBuilder
													.fromCurrentRequest()
													.path("/{id}")
													.buildAndExpand(savedStudent.getId())
													.toUri();

		return ResponseEntity.created(location).build();

	}
	
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		student.setId(id);
		
		studentRepository.save(student);

		return ResponseEntity.noContent().build();
	}
}