package com.rohit.spring_sec_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user_table")
public class User {
	@Id
	private int id;
	private String username;
	private String password;
	
	
}
