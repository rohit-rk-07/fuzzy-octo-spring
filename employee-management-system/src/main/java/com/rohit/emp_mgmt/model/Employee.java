package com.rohit.emp_mgmt.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee_table")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_email")
	private String email;
	
	@Column(name="emp_phone")
	private String phone;
	
	@Column(name="emp_salary")
	private int salary;
	
	@Column(name="emp_join_date")
	private Date joiningDate;
	
	@Column(name="emp_department")
	private String department;
	
}

