package com.rohit.emp_mgmt.dto;

public record DashboardStatsDTO(
		long totalEmployees,
		long totalRoles,
		long totalProjects,
		long totalDepartments
		) { }
