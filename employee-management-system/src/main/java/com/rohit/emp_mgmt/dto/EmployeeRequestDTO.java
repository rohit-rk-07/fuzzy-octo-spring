package com.rohit.emp_mgmt.dto;

import java.util.Date;

public record EmployeeRequestDTO (
		
		String name,
		String email,
		String phone,
		String gender,
		int salary,
		Date joiningDate,
		String status,
		int departmentId,
		int roleId
		) { }
