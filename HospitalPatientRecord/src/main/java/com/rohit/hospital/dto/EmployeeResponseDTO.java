package com.rohit.hospital.dto;

import java.util.Date;

public record EmployeeResponseDTO(
		
		Integer id,
		String name,
		String email,
		String phone,
		int salary,
		Date joiningDate,
		String department
		) {}
