package com.rohit.emp_mgmt.dto;

public record ProjectStatus(
		long projectID,
		String status,
		long totalEmployees
		) {}
