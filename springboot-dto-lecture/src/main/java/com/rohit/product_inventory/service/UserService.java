package com.rohit.product_inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.product_inventory.dto.UserLocationDTO;
import com.rohit.product_inventory.model.User;
import com.rohit.product_inventory.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserLocationDTO> getAllUsersLocation(){
		return userRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
	
	private UserLocationDTO convertEntityToDto(User user) {
		UserLocationDTO userLocationDTO = new UserLocationDTO();
		
		userLocationDTO.setUserId(user.getId());
		userLocationDTO.setEmail(user.getEmail());
		userLocationDTO.setPlace(user.getLocation().getPlace());
		userLocationDTO.setLatitude(user.getLocation().getLatitude());
		userLocationDTO.setLongitude(user.getLocation().getLongitude());
		
		return userLocationDTO;
	}
	
}
