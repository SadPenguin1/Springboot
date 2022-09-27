package com.example.SpringJPA.dao;

import java.util.List;

import com.example.SpringJPA.entity.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
	
	public void addEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
		
	public Employee getEmployee( int id);

	

 
	
	
	

}
