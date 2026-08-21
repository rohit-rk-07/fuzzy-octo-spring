package com.rohit.emp_mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rohit.emp_mgmt.dto.RoleRequestDTO;
import com.rohit.emp_mgmt.dto.RoleResponseDTO;
import com.rohit.emp_mgmt.service.RoleService;

@Controller
@RequestMapping("/api")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	//GET API END-POINT TO RETRIEVE ALL THE ROLES DATA
	@GetMapping("/roles")
	public ResponseEntity<List<RoleResponseDTO>> getRoles(){
		List<RoleResponseDTO> roles = roleService.getRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	//GET API END-POINT TO RERIEVE A SPECIFIC ROLE DATA USING THE ID
	@GetMapping("/roles/{Id}")
	public ResponseEntity<RoleResponseDTO> getRoleById(@PathVariable int Id){
		RoleResponseDTO role = roleService.getRoleById(Id);
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	//POST API END-POINT TO SAVE THE ROLE DATA INTO THE DB
	@PostMapping("/roles")
	public ResponseEntity<RoleResponseDTO> saveRole(@RequestBody RoleRequestDTO requestDto) {
		RoleResponseDTO savedRole = roleService.saveRole(requestDto);
		return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
	}
	
	//PUT API END-POINT TO UPDATE THE EXISTING ROLE DATA
	@PutMapping("/roles/{Id}")
	public ResponseEntity<?> updateRole(@RequestBody RoleRequestDTO requestDTO, @PathVariable int Id) {
		RoleResponseDTO updatedRole = roleService.updateRole(requestDTO, Id);
		if(updatedRole != null) {
			return new ResponseEntity<>(updatedRole, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//DELETE API END-POINT TO DELETE THE SPECIFIC ROLE BY ID
	@DeleteMapping("/roles/{Id}")
	public ResponseEntity<?> deleteRole(@PathVariable int Id) {
		RoleResponseDTO role = roleService.getRoleById(Id);
		if(role != null) {
			roleService.deleteRole(Id);
			return new ResponseEntity<>("Deleted.", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
