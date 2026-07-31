package com.rohit.SpringEcom.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="orders")
public class Order {
	
	@Id
	private Long id;
	
	@Column(unique = true)
	private String orderId;
	private String customerName;
	private String email;
	private String status;
	private LocalDate orderDate;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItem;
}
