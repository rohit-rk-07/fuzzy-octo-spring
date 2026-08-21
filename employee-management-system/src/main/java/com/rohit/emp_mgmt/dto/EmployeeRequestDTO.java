package com.rohit.emp_mgmt.dto;

import java.util.Date;

public record EmployeeRequestDTO (
		
		String name,
		String email,
		String phone,
		int salary,
		Date joiningDate,
		int departmentId,
		int roleId
		) { }
