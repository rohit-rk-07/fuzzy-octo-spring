package com.rohit.emp_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.emp_mgmt.dto.ProjectRequestDTO;
import com.rohit.emp_mgmt.dto.ProjectResponseDTO;
import com.rohit.emp_mgmt.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	public ResponseEntity<List<ProjectResponseDTO>> getProjects() {
		List<ProjectResponseDTO> projects = projectService.getProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable int id) {
		ProjectResponseDTO project = projectService.getProjectById(id);
		if(project != null) {
			return new ResponseEntity<>(project, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/projects")
	public ResponseEntity<ProjectResponseDTO> saveProject(@RequestBody ProjectRequestDTO projectDTO) {
		ProjectResponseDTO savedProject = projectService.saveProject(projectDTO);
		return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
	}
	
}
