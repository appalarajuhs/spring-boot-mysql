package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void saveStudent(Student student) {
		studentRepository.save(student);
		
	}
	
	public Optional<Student> getStudent(Integer id)
	{
		return  studentRepository.findById(id);
		
		
	}

}
