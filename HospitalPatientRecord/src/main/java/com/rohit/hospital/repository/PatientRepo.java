package com.rohit.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.hospital.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
