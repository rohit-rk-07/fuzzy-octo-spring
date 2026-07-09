package com.rohit;

public class Alien {
	
	private int age;
	private Computer com;
	
	public Alien() {
		System.out.println("Alien object created!");
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Computer getCom() {
		return com;
	}

	public void setCom(Computer com) {
		this.com = com;
	}
	
	public void code() {
		System.out.println(age);
		System.out.println("Coding");
		com.compile();
	}

}
