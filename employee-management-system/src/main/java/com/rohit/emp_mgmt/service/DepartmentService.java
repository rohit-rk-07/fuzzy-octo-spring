package com.rohit.emp_mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.emp_mgmt.dto.DepartmentRequestDTO;
import com.rohit.emp_mgmt.dto.DepartmentResponseDTO;
import com.rohit.emp_mgmt.model.Department;
import com.rohit.emp_mgmt.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepo;

	public List<DepartmentResponseDTO> getAllDepartments() {
		List<Department> departments = departmentRepo.findAll();
		
		return departments.stream().map( department -> new DepartmentResponseDTO(
				department.getId(),
				department.getName(),
				department.getLocation()
				)).toList();
	}

	public DepartmentResponseDTO getDepartmentById(int departmentId) {
		Department department = departmentRepo.findById(departmentId).orElse(null);
		
		if(department != null) {
			return new DepartmentResponseDTO(
					department.getId(),
					department.getName(),
					department.getLocation()
					);
		}
		
		return null;
	}

	public DepartmentResponseDTO addDepartment(DepartmentRequestDTO departmentRequestDto) {
		Department department = new Department();
		department.setName(departmentRequestDto.name());
		department.setLocation(departmentRequestDto.location());
		
		Department savedDepartment = departmentRepo.save(department);
		
		return new DepartmentResponseDTO(
				savedDepartment.getId(),
				savedDepartment.getName(),
				savedDepartment.getLocation()
				);
	}

	public DepartmentResponseDTO updateDepartment(DepartmentRequestDTO departmentRequestDto, int departmentId) {
		Department department = departmentRepo.findById(departmentId).orElse(null);
		
		department.setName(departmentRequestDto.name());
		department.setLocation(departmentRequestDto.location());
		
		Department updatedDepartment = departmentRepo.save(department);
		
		return new DepartmentResponseDTO(
				updatedDepartment.getId(),
				updatedDepartment.getName(),
				updatedDepartment.getLocation()
				);
	}

	public void deleteDepartment(int departmentId) {
		departmentRepo.deleteById(departmentId);
	}

}
