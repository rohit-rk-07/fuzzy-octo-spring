package com.rohit.emp_mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.emp_mgmt.dto.DashboardStatsDTO;
import com.rohit.emp_mgmt.dto.ProjectStatus;
import com.rohit.emp_mgmt.model.Project;
import com.rohit.emp_mgmt.repository.DepartmentRepository;
import com.rohit.emp_mgmt.repository.EmployeeRepository;
import com.rohit.emp_mgmt.repository.ProjectRepository;
import com.rohit.emp_mgmt.repository.RoleRepository;

@Service
public class DashboardService {

	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private DepartmentRepository departmentRepo;
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private ProjectRepository projectRepo;
	
	
	public DashboardStatsDTO getStats() {
		
		long totalEmployees = employeeRepo.count();
		long totalRoles = roleRepo.count();
		long totalDepartments = departmentRepo.count();
		long totalProjects = projectRepo.count();
		
		return new DashboardStatsDTO(
				totalEmployees,
				totalRoles,
				totalProjects,
				totalDepartments
				);
	}


	public List<ProjectStatus> getProjectsStatus() {
		List<Project> projects = projectRepo.findAll();
		
		return projects.stream()
                .map(project -> new ProjectStatus(
                        project.getId(),
                        project.getStatus(),
                        project.getEmployees() != null ? project.getEmployees().size() : 0
                ))
                .toList();
	}
	
}
