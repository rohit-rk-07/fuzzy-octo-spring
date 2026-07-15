package com.rohit;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("IN SERVICE METHOD");
	}
	
}
