package com.rohit.emp_mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.emp_mgmt.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
