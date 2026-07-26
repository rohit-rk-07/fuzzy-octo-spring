package com.rohit.SpringEcom.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.SpringEcom.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
}
