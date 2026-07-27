package com.rohit.SpringEcom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.SpringEcom.model.Product;
import com.rohit.SpringEcom.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	public List<Product> getAllProducts() {
		return productRepo.findAll();
		
	}

	public Product getProductById(int id) {
		
		return productRepo.findById(id).orElse(null);
	}
	
}
