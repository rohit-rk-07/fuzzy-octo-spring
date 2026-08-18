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

import com.rohit.emp_mgmt.dto.DepartmentRequestDTO;
import com.rohit.emp_mgmt.dto.DepartmentResponseDTO;
import com.rohit.emp_mgmt.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	//this GET End-Point will get all the departments data from the database
	@GetMapping("/departments")
	public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments(){
		List<DepartmentResponseDTO> departments = departmentService.getAllDepartments();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}
	
	//GET End-Point will get a specific data of department by Id from database
	@GetMapping("/departments/{id}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable("id") int departmentId) {
		DepartmentResponseDTO department = departmentService.getDepartmentById(departmentId);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}
	
	//POST End-Point to save or add data of department into the database
	@PostMapping("/departments")
	public ResponseEntity<DepartmentResponseDTO> addDepartment(@RequestBody DepartmentRequestDTO departmentRequestDto) {
		
		DepartmentResponseDTO department = departmentService.addDepartment(departmentRequestDto);
		
		return null;
	}
}
