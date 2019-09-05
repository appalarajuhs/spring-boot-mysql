package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;
@XmlRootElement
@Entity
@Table
@Setter
@Getter
public class Student {

	@Id
	@CsvBindByPosition(position = 0)
	private int id;
	@CsvBindByPosition(position = 1)
	private String name;
	@CsvBindByPosition(position = 2)
	private String address;
	
	
	public Student() {
	
		
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}


	
}
