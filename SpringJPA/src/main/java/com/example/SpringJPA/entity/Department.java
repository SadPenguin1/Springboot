package com.example.SpringJPA.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;		
		private String name;
		
		
		@OneToMany(mappedBy ="department",fetch = FetchType.LAZY)
		List<Employee> employees;
		
	

	}

