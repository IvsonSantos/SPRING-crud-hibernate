package com.ivson.study.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivson.study.model.Student;
import com.ivson.study.service.StudentService;

/**
 * Combination of @Controller and @ResponseBody. Beans returned are converted
 * to/from JSON/XML.
 */
@RestController
public class StudentResource {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentService.retrieveAllStudents();
	}

	@GetMapping("/students/{id}")
	public Student retrieveStudent(@PathVariable long id) {		
		return studentService.retrieveStudent(id);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {		
		return studentService.createStudent(student);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {
		return studentService.updateStudent(student, id);
	}
	
}