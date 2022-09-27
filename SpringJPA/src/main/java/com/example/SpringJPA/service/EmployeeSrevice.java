package com.example.SpringJPA.service;

import java.util.List;

import com.example.SpringJPA.model.EmployeeDTO;

public interface EmployeeSrevice {
	public List<EmployeeDTO> getAllEmployees();
	
	public void addEmployee(EmployeeDTO employee);
	
	public void deleteEmployee(int id);
	
	public void updateEmployee(EmployeeDTO employee);
	
	public EmployeeDTO getEmployeeDTO(int id);

	
}
