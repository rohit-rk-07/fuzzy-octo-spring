package com.rohit;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class Desktop implements Computer {

	public Desktop() {
		System.out.println("Desktop object created!");
	}
	
	public void compile() {
		System.out.println("compiling! from desktop");
	}
	
}
