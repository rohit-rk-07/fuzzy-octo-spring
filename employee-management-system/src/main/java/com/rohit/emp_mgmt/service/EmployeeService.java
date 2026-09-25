package com.rohit.emp_mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rohit.emp_mgmt.dto.DashboardStatsDTO;
//import com.rohit.emp_mgmt.controller.EmployeeResponseDTO;
import com.rohit.emp_mgmt.dto.EmployeeRequestDTO;
import com.rohit.emp_mgmt.dto.EmployeeResponseDTO;
import com.rohit.emp_mgmt.model.Department;
import com.rohit.emp_mgmt.model.Employee;
import com.rohit.emp_mgmt.model.Role;
import com.rohit.emp_mgmt.repository.DepartmentRepository;
import com.rohit.emp_mgmt.repository.EmployeeRepository;
import com.rohit.emp_mgmt.repository.RoleRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//method to get all employees from the repository
	public List<EmployeeResponseDTO> getAllEmployees(){
		List<Employee> employees = employeeRepo.findAll();
		
		return employees.stream().map(employee -> new EmployeeResponseDTO(
				employee.getId(),
				employee.getName(),
				employee.getEmail(),
				employee.getGender(),
				employee.getPhone(),
				employee.getSalary(),
				employee.getJoiningDate(),
				employee.getStatus(),
				employee.getDepartment().getId(),
				employee.getDepartment().getName(),
				employee.getRole().getId(),
				employee.getRole().getRole()
				)).toList();
	}
	
	//method to get specific employee by Id
	public EmployeeResponseDTO getEmployeeById(int id) {
		
		Employee employee = employeeRepo.findById(id).orElse(null);
		
		if(employee != null) {
			return new EmployeeResponseDTO(
					employee.getId(),
					employee.getName(),
					employee.getEmail(),
					employee.getGender(),
					employee.getPhone(),
					employee.getSalary(),
					employee.getJoiningDate(),
					employee.getStatus(),
					employee.getDepartment().getId(),
					employee.getDepartment().getName(),
					employee.getRole().getId(),
					employee.getRole().getRole()
			);
		}
		return null;
	}
	
	//this service method used to add the employee
	public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setName(employeeDTO.name());
		employee.setEmail(employeeDTO.email());
		employee.setGender(employeeDTO.gender());
		employee.setPhone(employeeDTO.phone());
		employee.setSalary(employeeDTO.salary());
		employee.setStatus(employeeDTO.status());
		employee.setJoiningDate(employeeDTO.joiningDate());
		
		Department department = departmentRepo
								.findById(employeeDTO.departmentId())
								.orElseThrow( () -> new RuntimeException("Department not found"));
		employee.setDepartment(department);
		
		Role role = roleRepository
					.findById(employeeDTO.roleId())
					.orElseThrow( () -> new RuntimeException("Role not found"));
		employee.setRole(role);
		
		Employee savedEmployee = employeeRepo.save(employee);
		
		return new EmployeeResponseDTO(
				savedEmployee.getId(),
				savedEmployee.getName(),
				savedEmployee.getEmail(),
				savedEmployee.getGender(),
				savedEmployee.getPhone(),
				savedEmployee.getSalary(),
				savedEmployee.getJoiningDate(),
				savedEmployee.getStatus(),
				savedEmployee.getDepartment().getId(),
				savedEmployee.getDepartment().getName(),
				savedEmployee.getRole().getId(),
				savedEmployee.getRole().getRole()
		);
	}
	
	public EmployeeResponseDTO UpdateEmployee(int id, EmployeeRequestDTO employeeDTO) {
		
		Employee employee = employeeRepo.findById(id).orElse(null);
		
		if(employee == null) return null;
		
		employee.setName(employeeDTO.name());
		employee.setEmail(employeeDTO.email());
		employee.setPhone(employeeDTO.phone());
		employee.setGender(employeeDTO.gender());
		employee.setSalary(employeeDTO.salary());
		employee.setStatus(employeeDTO.status());
		employee.setJoiningDate(employeeDTO.joiningDate());
		
		Department department = departmentRepo
								.findById(employeeDTO.departmentId())
								.orElseThrow(() -> new RuntimeException("Department not found"));
		employee.setDepartment(department);
		
		Role role = roleRepository
					.findById(employeeDTO.roleId())
					.orElseThrow(() -> new RuntimeException("Role not found"));
		
		Employee updatedEmployee = employeeRepo.save(employee);
		
		return new EmployeeResponseDTO(
				updatedEmployee.getId(),
				updatedEmployee.getName(),
				updatedEmployee.getEmail(),
				updatedEmployee.getGender(),
				updatedEmployee.getPhone(),
				updatedEmployee.getSalary(),
				updatedEmployee.getJoiningDate(),
				updatedEmployee.getStatus(),
				updatedEmployee.getDepartment().getId(),
				updatedEmployee.getDepartment().getName(),
				updatedEmployee.getRole().getId(),
				updatedEmployee.getRole().getRole()
		);
	}
	
	//this method is used to delete the employee by Id
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}

	//this method is used to get employees details by searching by keywords
	public List<EmployeeResponseDTO> searchEmployees(String keyword) {
		
		List<Employee> employees = employeeRepo.searchEmployees(keyword);
		
		return employees.stream()
				.map(employee -> new EmployeeResponseDTO(
					employee.getId(),
					employee.getName(),
					employee.getEmail(),
					employee.getGender(),
					employee.getPhone(),
					employee.getSalary(),
					employee.getJoiningDate(),
					employee.getStatus(),
					employee.getDepartment().getId(),
					employee.getDepartment().getName(),
					employee.getRole().getId(),
					employee.getRole().getRole()
				)).toList();
	}

	public List<EmployeeResponseDTO> getEmployeeLimit(String sort, int limit) {
		
		Pageable pageable = PageRequest.of(0, limit);
		
		List<Employee> employees;
		if(sort.equalsIgnoreCase("asc")) {
			employees = employeeRepo.findEmployeesAsc(pageable);
		} else {
			employees = employeeRepo.findEmployeesDesc(pageable);
		}
		
		return employees.stream().map(employee -> new EmployeeResponseDTO(
				employee.getId(),
				employee.getName(),
				employee.getEmail(),
				employee.getGender(),
				employee.getPhone(),
				employee.getSalary(),
				employee.getJoiningDate(),
				employee.getStatus(),
				employee.getDepartment().getId(),
				employee.getDepartment().getName(),
				employee.getRole().getId(),
				employee.getRole().getRole()
				)).toList();
	}

	public List<EmployeeResponseDTO> getByDepartmentID(int department) {
		List<Employee> employees = employeeRepo.findEmployeesByDepartmentID(department);
		
		return employees.stream().map( employee -> new EmployeeResponseDTO(
				employee.getId(),
				employee.getName(),
				employee.getEmail(),
				employee.getGender(),
				employee.getPhone(),
				employee.getSalary(),
				employee.getJoiningDate(),
				employee.getStatus(),
				employee.getDepartment().getId(),
				employee.getDepartment().getName(),
				employee.getRole().getId(),
				employee.getRole().getRole()
				)).toList();
	}
	
	public List<EmployeeResponseDTO> getByRoleID(int role) {
		List<Employee> employees = employeeRepo.findEmployeesByRoleID(role);
		
		return employees.stream().map( employee -> new EmployeeResponseDTO(
				employee.getId(),
				employee.getName(),
				employee.getEmail(),
				employee.getGender(),
				employee.getPhone(),
				employee.getSalary(),
				employee.getJoiningDate(),
				employee.getStatus(),
				employee.getDepartment().getId(),
				employee.getDepartment().getName(),
				employee.getRole().getId(),
				employee.getRole().getRole()
				)).toList();
 	}
	
}
