package com.ivson.study.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivson.study.model.Student;
import com.ivson.study.repository.StudentRepository;

/**
 * Combination of @Controller and @ResponseBody. 
 * Beans returned are converted to/from JSON/XML.
 */
@RestController
public class StudentResource {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}
}
