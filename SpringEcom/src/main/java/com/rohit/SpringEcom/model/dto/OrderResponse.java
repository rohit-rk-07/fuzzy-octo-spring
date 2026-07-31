package com.rohit.SpringEcom.model.dto;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
		String orderId, 
		String customerName,
		String email,
		LocalDate orderDate,
		List<OrderItemResponse> item
		
) { }
