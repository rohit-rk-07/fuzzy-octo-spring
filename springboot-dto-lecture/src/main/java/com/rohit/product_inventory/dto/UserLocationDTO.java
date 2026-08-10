package com.rohit.product_inventory.dto;

import lombok.Data;

@Data
public class UserLocationDTO {
	
	private long userId;
	private String email;
	private String place;
	private double latitude;
	private double longitude;
}
