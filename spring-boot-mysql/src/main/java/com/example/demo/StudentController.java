package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	//sample project created sucessfully.
	@Autowired
	private StudentService studentStudent;
	
	@PostMapping("save")
	public Student saveStudent(@RequestBody Student student) {
		studentStudent.saveStudent(student);
		return student;
		
	}
	
	  @GetMapping("getbyid/{id}")
	  public Optional<Student> getStudentbyid(@PathVariable("id")Integer id) {
		  
		  Optional<Student> obj=  studentStudent.getStudent(id);
		  
		  
		return obj;
	  
  
	  }
	 

}
