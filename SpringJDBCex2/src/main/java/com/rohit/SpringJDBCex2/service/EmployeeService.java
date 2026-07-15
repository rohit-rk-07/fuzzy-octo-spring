package com.rohit.SpringJDBCex2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.SpringJDBCex2.model.Employee;
import com.rohit.SpringJDBCex2.repo.EmployeeRepo;

@Service	
public class EmployeeService {
	
	private EmployeeRepo repo;

	//getters and setters
	public EmployeeRepo getRepo() {
		return repo;
	}
	@Autowired
	public void setRepo(EmployeeRepo repo) {
		this.repo = repo;
	}
	
	//add employee method
	public void addEmployee(Employee e) {
		repo.save(e);
	}
	
	//get all employees method
	public List<Employee> getEmployee() {
		return repo.findAll();
	}
}
