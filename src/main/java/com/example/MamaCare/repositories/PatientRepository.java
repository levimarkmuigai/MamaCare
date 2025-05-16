package com.example.MamaCare.repositories;

import com.example.MamaCare.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{}
