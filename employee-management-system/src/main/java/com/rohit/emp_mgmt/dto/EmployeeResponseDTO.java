package com.rohit.emp_mgmt.dto;

import java.util.Date;

public record EmployeeResponseDTO(
		
		Integer id,
		String name,
		String email,
		String phone,
		int salary,
		Date joiningDate,
		int departmentId,
		String departmentName
		) {}
