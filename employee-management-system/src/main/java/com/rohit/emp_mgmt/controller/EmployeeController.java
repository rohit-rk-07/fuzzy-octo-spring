package com.rohit.emp_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.emp_mgmt.model.Employee;
import com.rohit.emp_mgmt.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	//Get-api end-point to get all the employee details 
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
	}
	
}
