package com.example.demo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@RestController
public class StudentController {
	// sample project created sucessfully.
	@Autowired
	private StudentService studentStudent;

	@PostMapping("save")
	public Student saveStudent(@RequestBody Student student) {
		studentStudent.saveStudent(student);
		return student;

	}

	@GetMapping("getbyid/{id}")
	public Optional<Student> getStudentbyid(@PathVariable("id") Integer id) {

		Optional<Student> obj = studentStudent.getStudent(id);

		return obj;

	}

	@GetMapping(value = "allstudentdata", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Student> AllStudentsData() {
		List<Student> list = studentStudent.AllStudentsData();

		return list;

	}

	
	  
	  @GetMapping("export-users") 
	  public void exportCSV(HttpServletResponse
	  response) throws Exception {
	  
	//  set file name and content type
	  String filename = "users.csv";
	  
	  response.setContentType("text/csv");
	  response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
	  
	 // create a csv writer 
	  StatefulBeanToCsv<Student> writer = new
	  StatefulBeanToCsvBuilder<Student>(response.getWriter())
	  .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
	  .withSeparator(CSVWriter.DEFAULT_SEPARATOR) .withOrderedResults(false)
	  .build();
	  
	  //write all users to csv file 
	  writer.write(AllStudentsData()); }
	 
}
