package com.rohit.hospital.dto;

import java.util.Date;

public record EmployeeRequestDTO (
		
		String name,
		String email,
		String phone,
		int salary,
		Date joiningDate,
		String department
		) { }
