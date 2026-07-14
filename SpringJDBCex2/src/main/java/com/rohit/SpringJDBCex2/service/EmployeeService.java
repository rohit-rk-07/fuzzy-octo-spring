package com.rohit.SpringJDBCex2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.SpringJDBCex2.model.Employee;
import com.rohit.SpringJDBCex2.repo.EmployeeRepo;

@Service	
public class EmployeeService {
	
	private EmployeeRepo repo;

	public EmployeeRepo getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(EmployeeRepo repo) {
		this.repo = repo;
	}
	
	public void addEmployee(Employee e) {
		repo.save(e);
	}
	
	public List<Employee> getEmployee() {
		return repo.findAll();
	}
}
