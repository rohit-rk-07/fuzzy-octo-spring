package com.rohit.emp_mgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rohit.emp_mgmt.model.Employee;
import com.rohit.emp_mgmt.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepo;
	
	//method to get all employees from the repository
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
	
	//method to get specific employee by Id
	public Employee getEmployeeById(int id) {
		return employeeRepo.findById(id).orElse(null);
	}
	
	//this method used to add or update the employee
	public Employee addOrUpdateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//this method is used to delete the employee by Id
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}
	
}
