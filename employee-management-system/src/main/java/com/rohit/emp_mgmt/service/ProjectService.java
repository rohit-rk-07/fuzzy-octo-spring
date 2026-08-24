package com.rohit.emp_mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.emp_mgmt.dto.EmployeeResponseDTO;
import com.rohit.emp_mgmt.dto.ProjectRequestDTO;
import com.rohit.emp_mgmt.dto.ProjectResponseDTO;
import com.rohit.emp_mgmt.model.Employee;
import com.rohit.emp_mgmt.model.Project;
import com.rohit.emp_mgmt.repository.EmployeeRepository;
import com.rohit.emp_mgmt.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepo;

	public List<ProjectResponseDTO> getProjects() {
		List<Project> projects = projectRepository.findAll();	
		return projects.stream().map(project -> new ProjectResponseDTO(
				project.getId(),
				project.getName(),
				project.getDescription(),
				project.getStartDate(),
				project.getEndDate(),
				project.getStatus(),
				
				project.getEmployees().stream()
						.map(employee -> new EmployeeResponseDTO(
								employee.getId(),
								employee.getName(),
								employee.getEmail(),
								employee.getPhone(),
								employee.getSalary(),
								employee.getJoiningDate(),
								employee.getDepartment().getId(),
								employee.getDepartment().getName(),
								employee.getRole().getId(),
								employee.getRole().getRole()
								)
								).toList()
				)
				).toList();
	}

	public ProjectResponseDTO getProjectById(int id) {
		Project project = projectRepository.findById(id).orElseThrow(null);
		
		return new ProjectResponseDTO(
				project.getId(),
				project.getName(),
				project.getDescription(),
				project.getStartDate(),
				project.getEndDate(),
				project.getStatus(),
				
				project.getEmployees().stream()
						.map(employee -> new EmployeeResponseDTO(
								employee.getId(),
								employee.getName(),
								employee.getEmail(),
								employee.getPhone(),
								employee.getSalary(),
								employee.getJoiningDate(),
								employee.getDepartment().getId(),
								employee.getDepartment().getName(),
								employee.getRole().getId(),
								employee.getRole().getRole()
								)
								).toList()
				);
	}

	public ProjectResponseDTO saveProject(ProjectRequestDTO projectDTO) {
		Project project = new Project();
		project.setName(projectDTO.name());
		project.setDescription(projectDTO.description());
		project.setStartDate(projectDTO.startDate());
		project.setEndDate(projectDTO.endDate());
		project.setStatus(projectDTO.status());
		
		List<Employee> employees = employeeRepo.findAllById(projectDTO.employeesIds());
		project.setEmployees(employees);
		
		Project savedProject = projectRepository.save(project);
		
		return new ProjectResponseDTO(
				savedProject.getId(),
				savedProject.getName(),
				savedProject.getDescription(),
				savedProject.getStartDate(),
				savedProject.getEndDate(),
				savedProject.getStatus(),
				savedProject.getEmployees().stream()
							.map( employee -> new EmployeeResponseDTO(
									employee.getId(),
									employee.getName(),
									employee.getEmail(),
									employee.getPhone(),
									employee.getSalary(),
									employee.getJoiningDate(),
									employee.getDepartment().getId(),
									employee.getDepartment().getName(),
									employee.getRole().getId(),
									employee.getRole().getRole()
								)
									).toList()
				);
	}

	public ProjectResponseDTO updateProject(ProjectRequestDTO projectDTO, int id) {
		
		Project project = projectRepository.findById(id).orElseThrow();
		project.setName(projectDTO.name());
		project.setDescription(projectDTO.description());
		project.setStartDate(projectDTO.startDate());
		project.setEndDate(projectDTO.endDate());
		project.setStatus(projectDTO.status());
		List<Employee> employees = employeeRepo.findAllById(projectDTO.employeesIds());
		project.setEmployees(employees);
		
		Project updatedProject = projectRepository.save(project);
		
		return new ProjectResponseDTO(
					updatedProject.getId(),
					updatedProject.getName(),
					updatedProject.getDescription(),
					updatedProject.getStartDate(),
					updatedProject.getEndDate(),
					updatedProject.getStatus(),
					updatedProject.getEmployees().stream()
					.map( employee -> new EmployeeResponseDTO(
							employee.getId(),
							employee.getName(),
							employee.getEmail(),
							employee.getPhone(),
							employee.getSalary(),
							employee.getJoiningDate(),
							employee.getDepartment().getId(),
							employee.getDepartment().getName(),
							employee.getRole().getId(),
							employee.getRole().getRole()
						)
							).toList()
				);
	}

	public void deleteProjectById(int id) {
		projectRepository.deleteById(id);
	} 

}
