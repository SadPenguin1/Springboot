package com.example.SpringJPA.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

// Class co chuc nang map voi bang du lieu,bao nhieu bang bay nhieu class
@Data
@Entity
@Table(name = "phone")
public class Phone implements Serializable{
	
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="phone_number")
	//@Column(unique =true)
	private String phone;
	
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;


	


}
