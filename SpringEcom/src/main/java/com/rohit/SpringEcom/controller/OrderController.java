package com.rohit.SpringEcom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.SpringEcom.model.dto.OrderRequest;
import com.rohit.SpringEcom.model.dto.OrderResponse;
import com.rohit.SpringEcom.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders/place")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
		OrderResponse orderResponse = orderService.placeOrder(orderRequest);
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> getAllOrders(){
		List<OrderResponse> response = orderService.getAllOrdersResponses();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
