package com.rohit.app.repo;

import org.springframework.stereotype.Component;

import com.rohit.app.model.Laptop;

@Component
public class LaptopRepository {
	public void save(Laptop lap) {
		System.out.println("Saved in Database...");
	}
}