package com.rohit.product_inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product_table")
public class ProductModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long procuct_id;
	private String product_name;
	private String description;
	private String category;
	private double price;
	private int quantity;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
}
