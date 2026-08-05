package com.rohit.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.hospital.model.Patient;
import com.rohit.hospital.service.PatientService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

	@Autowired
	PatientService patientService;
	
	//API end-point to get all patients records
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> getPatients(){
		return new ResponseEntity<>(patientService.getAppPatients(), HttpStatus.OK);
	}
	
	//API end-point to get patient data by id
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int id){
		Patient patient = patientService.getPatientById(id);
		return (patient != null) ? new ResponseEntity<>(patient, HttpStatus.OK) 
						  		 : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	//API end-point to add  patient record in to the db
	@PostMapping("/patients")
	public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
		Patient savedPatient = null;
		try {
			savedPatient = patientService.addOrUpdatePatient(patient);
			return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to add patient.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//API end-point to update patient record
	@PutMapping("/patients/{id}")
	public ResponseEntity<String> updatePatient(@PathVariable int id, @RequestBody Patient patient) {
		Patient updatePatient = null;
		try {
			updatePatient = patientService.addOrUpdatePatient(patient);
			return new ResponseEntity<>("Updated.", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage() ,HttpStatus.BAD_REQUEST);
		}
	}
	
	//API end-point to delete the patient record
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable int id){
		try {
			patientService.deletePatient(id);
			return new ResponseEntity<>("Deleted.", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
