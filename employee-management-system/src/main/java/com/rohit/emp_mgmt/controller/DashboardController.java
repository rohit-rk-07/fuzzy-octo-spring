package com.rohit.emp_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.emp_mgmt.dto.DashboardStatsDTO;
import com.rohit.emp_mgmt.dto.ProjectStatus;
import com.rohit.emp_mgmt.service.DashboardService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/dashboard/stats")
	public ResponseEntity<DashboardStatsDTO> dashboardStats() {
		DashboardStatsDTO stats = dashboardService.getStats();
		return new ResponseEntity<>(stats, HttpStatus.OK);
	}
	
	@GetMapping("/dashboard/project_status")
	public ResponseEntity<List<ProjectStatus>> getProjectsStatus() {
		List<ProjectStatus> projectStatus = dashboardService.getProjectsStatus();
		return new ResponseEntity<>(projectStatus, HttpStatus.OK);
	}
}
