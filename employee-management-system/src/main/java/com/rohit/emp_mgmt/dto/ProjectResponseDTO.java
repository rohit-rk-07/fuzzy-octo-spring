package com.rohit.emp_mgmt.dto;

import java.util.Date;
import java.util.List;

public record ProjectResponseDTO(
		int id,
		String name,
		String description,
		Date startDate,
		Date endDate,
		String status,
		List<EmployeeResponseDTO> employees
) { }

//id
//name
//description
//startDate
//endDate
//status