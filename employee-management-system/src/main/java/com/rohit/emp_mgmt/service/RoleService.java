package com.rohit.emp_mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.emp_mgmt.dto.RoleRequestDTO;
import com.rohit.emp_mgmt.dto.RoleResponseDTO;
import com.rohit.emp_mgmt.model.Role;
import com.rohit.emp_mgmt.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	//FETCHES ROLES DATA FROM THE REPO, RETURNS BACK TO CONTROLLER
	public List<RoleResponseDTO> getRoles() {
		List<Role> roles = roleRepository.findAll();
		
		return roles.stream().map(role -> new RoleResponseDTO(
				role.getId(),
				role.getRole(),
				role.getDescription()
				)).toList();
	}

	//FETCHES A SPECIFIC ROLE DATA FROM THE REPO, RETURNS BACK TO CONTROLLER
	public RoleResponseDTO getRoleById(int roleId) {
		Role role = roleRepository.findById(roleId).orElseThrow( () -> new RuntimeException("Role not found."));
		return new RoleResponseDTO(
				role.getId(),
				role.getRole(),
				role.getDescription()
				);
	}

	public RoleResponseDTO saveRole(RoleRequestDTO requestDto) {
		Role role = new Role();
		
		role.setRole(requestDto.role());
		role.setDescription(requestDto.description());
		
		Role savedRole = roleRepository.save(role);
		return new RoleResponseDTO(
				savedRole.getId(),
				savedRole.getRole(),
				savedRole.getDescription()
				);
	}

	public RoleResponseDTO updateRole(RoleRequestDTO requestDTO, int id) {
		Role role = roleRepository.findById(id).orElse(null);
		role.setRole(requestDTO.role());
		role.setDescription(requestDTO.description());
		
		Role updatedRole = roleRepository.save(role);
		
		return new RoleResponseDTO(
				updatedRole.getId(),
				updatedRole.getRole(),
				updatedRole.getDescription()
				);
	}

	public void deleteRole(int id) {
		roleRepository.deleteById(id);
	}

}
