package com.example.SpringJPA.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
//Class DTO chua nhung thuoc tinh co the tuy bien them thuoc tinh (avatar) hoac khia bao nhieu bien hon de thuc thi qua trinh logic
//Class DTO dong vai tro trong viec su ly du lieu o nen view va controller , day model DTO nay sang view va lay du lieu tu view sang controller
//Trong lop Service se convert su lieu giua 2 class DTO va entity
@Data
public class EmployeeDTO {
	private int id;
	private String name;
	private int age;
	private MultipartFile avatar;
	private List<String> phones; 
		
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EmployeeDTO(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}

			
}
