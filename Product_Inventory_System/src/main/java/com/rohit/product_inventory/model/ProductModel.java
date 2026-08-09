package com.rohit.product_inventory.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

	private long procuct_id;
	private String product_name;
	private String description;
	private String category;
	private double price;
	private int quantity;
	private String supllier;
	
}
