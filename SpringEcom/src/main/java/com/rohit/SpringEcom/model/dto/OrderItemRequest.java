package com.rohit.SpringEcom.model.dto;

public record OrderItemRequest(
		int productId, 
		int quantity) 
{ }
