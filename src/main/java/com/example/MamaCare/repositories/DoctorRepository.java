package com.example.MamaCare.repositories;

import com.example.MamaCare.model.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{}
