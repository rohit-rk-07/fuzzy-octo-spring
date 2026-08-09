package com.rohit.hospital.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long patientId;
	String patient_name;
	int age;
	String gender;
	String disease;
	String doctor_name;
	Date admission_date;
	String phone_number;
	
}
