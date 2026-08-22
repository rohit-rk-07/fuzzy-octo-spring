package com.rohit.emp_mgmt.dto;

import java.util.Date;
import java.util.List;

public record ProjectRequestDTO(
		String name,
		String description,
		Date startDate,
		Date endDate,
		String status,
		List<Integer> employeesIds
) { }


//id
//name
//description
//startDate
//endDate
//status