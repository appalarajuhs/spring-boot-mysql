package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentStudent;
	
	@PostMapping("save")
	public Student saveStudent(@RequestBody Student student) {
		studentStudent.saveStudent(student);
		return student;
		
	}

}
