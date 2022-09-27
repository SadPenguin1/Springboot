package com.example.SpringJPA.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringJPA.model.EmployeeDTO;
import com.example.SpringJPA.service.EmployeeSrevice;

@Controller
public class MainController {
	@Autowired
	private EmployeeSrevice employeeSrevice;
	
	
	@Autowired
	Environment environment ;
	
	@GetMapping(value ="/hello")
	public String home(HttpServletRequest request) {
		request.setAttribute("msg", environment.getProperty("message"));
		return "hello.html";
	}
	
	@GetMapping(value="/employees")
	public String employees(HttpServletRequest request,Model model) {
		List<EmployeeDTO> employees = employeeSrevice.getAllEmployees();
		request.setAttribute("employees", employees);
		model.addAttribute("employee", new EmployeeDTO(1,"Dien ten vao day",23));		
		return "employees";
		
	}
	@PostMapping(value="/addemployees")
	public String addEmployee(HttpServletRequest request,@ModelAttribute(name= "employee") EmployeeDTO employee) {
		employeeSrevice.addEmployee(employee);
		return "redirect:/employees";
		
	
		
	}
	@GetMapping(value="/deleteemployees")
	public String deleteEmployee(@RequestParam(name ="id") int id) {
		
		employeeSrevice.deleteEmployee(id);
		return "redirect:/employees";		
	}
	
	@GetMapping(value="/update")
	public String update(@RequestParam(name ="id") int id,Model model) {
		EmployeeDTO employee= employeeSrevice.getEmployeeDTO(id);
		System.out.println(employee.getName());
		model.addAttribute("employee", employee);
		return "edit";
	}	
	
	@PostMapping(value="/update")
	public String update(@ModelAttribute EmployeeDTO employee) {
		employeeSrevice.updateEmployee(employee);
		return "redirect:/employees";	
	}
}
