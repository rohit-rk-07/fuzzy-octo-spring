package com.rohit.emp_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.emp_mgmt.dto.EmployeeRequestDTO;
import com.rohit.emp_mgmt.dto.EmployeeResponseDTO;
import com.rohit.emp_mgmt.model.Employee;
import com.rohit.emp_mgmt.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	//GET-API end-point to get all the employee details 
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.ACCEPTED);
	}
	
	//GET-API end-point to get a single specific employee details by Id;
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable int id){
		EmployeeResponseDTO employee = employeeService.getEmployeeById(id);
		
		if(employee != null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// this POST-API Controller end-point to store data of employee 
	@PostMapping("/employees")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeRequestDTO employeeDTO){
		EmployeeResponseDTO savedEmployee = employeeService.addEmployee(employeeDTO);
			return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//PUT-API end-point to update employee data
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable int id, @RequestBody EmployeeRequestDTO employeeDTO) {
		EmployeeResponseDTO updatedEmployee = employeeService.UpdateEmployee(id, employeeDTO);
		
		if(updatedEmployee != null) {
			return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// DELETE-API end-point to delete the employee by Id
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
			EmployeeResponseDTO employee = employeeService.getEmployeeById(id);
			
			if(employee != null) {
				employeeService.deleteEmployee(id);
				return new ResponseEntity<>("Deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	
	//GET-API SEARCH end-point to search employee on keyword
	@GetMapping("/employees/search")
	public ResponseEntity<List<EmployeeResponseDTO>> searchEmployees(@RequestParam String keyword) {
			List<EmployeeResponseDTO> employees = employeeService.searchEmployees(keyword);
			return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
}
