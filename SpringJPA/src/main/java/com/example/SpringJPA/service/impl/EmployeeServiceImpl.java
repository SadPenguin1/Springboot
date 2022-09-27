package com.example.SpringJPA.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringJPA.dao.EmployeeDao;
import com.example.SpringJPA.entity.Employee;
import com.example.SpringJPA.entity.Phone;
import com.example.SpringJPA.model.EmployeeDTO;
import com.example.SpringJPA.service.EmployeeSrevice;

@Service
@org.springframework.transaction.annotation.Transactional
public class EmployeeServiceImpl implements EmployeeSrevice{
	@Autowired
	public EmployeeDao employeeDao;
	
	@Override
	public List<EmployeeDTO> getAllEmployees(){
		List<Employee> employees = employeeDao.getAllEmployees(); 
		
		List<EmployeeDTO> dtos = new ArrayList<EmployeeDTO>();
		for (Employee e :employees) {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			
			
			//get phone number
			List<String> phoneList = new ArrayList<String>();
			for (Phone phone : e.getPhones()) {
				phoneList.add(phone.getPhone());
				
			}
			
			dto.setPhones(phoneList);
			dtos.add(dto);
		}
		return dtos;
		
	}

	@Override
	public void addEmployee(EmployeeDTO employee) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		
		e.setName(employee.getName());
		e.setAge(employee.getAge());
		
		
		List<Phone> phones = new ArrayList<Phone>();
		for(String s : employee.getPhones()) {
			Phone phone = new Phone();
			phone.setPhone(s);
			phone.setEmployee(e);
			
			phones.add(phone);
			}
		
		e.setPhones(phones);
		
		employeeDao.addEmployee(e);		
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.getEmployee(id);
		if(employee != null) {
			employeeDao.deleteEmployee(employee);
		}
		
	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.getEmployee(employeeDTO.getId());
		if(employee != null) {
		
			employee.setName(employeeDTO.getName());
			employee.setAge(employeeDTO.getAge());
			
			employee.getPhones().clear();
			
			List<Phone> phones = new ArrayList<Phone>();
			for(String s : employeeDTO.getPhones()) {
				Phone phone = new Phone();
				phone.setPhone(s);
				phone.setEmployee(employee);
				
				phones.add(phone);
				}
			employee.getPhones().addAll(phones);
			employeeDao.updateEmployee(employee);
		}		
	}


	@Override
	public EmployeeDTO getEmployeeDTO(int id) {
		EmployeeDTO dto = new EmployeeDTO();
		Employee e = employeeDao.getEmployee(id);	
		if(e != null) {
		
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			
		
			
		}	
		return dto;
	}
}