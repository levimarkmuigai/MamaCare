package com.example.MamaCare.repositories;

import com.example.MamaCare.model.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long>{}
