package com.example.MamaCare.repositories;

import com.example.MamaCare.model.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.*;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
        
    List<Appointment> findByNextAppointment(LocalDate date);
}
