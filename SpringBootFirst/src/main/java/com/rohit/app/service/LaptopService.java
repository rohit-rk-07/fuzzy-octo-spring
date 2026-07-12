package com.rohit.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.app.repo.LaptopRepository;
import com.rohit.app.model.Laptop;

@Service
public class LaptopService {
	
	@Autowired
	private LaptopRepository repo;
	
	public void addLaptop(Laptop lap) {
		repo.save(lap);
	}
	
	public boolean isGoodForProg(Laptop lap) {
		return true;
	}
}
