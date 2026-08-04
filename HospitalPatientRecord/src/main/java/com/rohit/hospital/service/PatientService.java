package com.rohit.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rohit.hospital.model.Patient;
import com.rohit.hospital.repository.PatientRepo;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepo patientRepo;

	//service method that retrieves all the patients data from repo 
	public List<Patient> getAppPatients() {
		return patientRepo.findAll();
	}

	//service method to retrieve only specific data based on id
	public Patient getPatientById(int id) {
		return patientRepo.findById(id).orElse(null);
	}

	//service method to transfer new Patient data from controller end point to repo
	public Patient addOrUpdatePatient(Patient patient) {
		return patientRepo.save(patient);
	}

}
