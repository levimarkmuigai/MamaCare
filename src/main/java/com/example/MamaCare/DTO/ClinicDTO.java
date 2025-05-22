package com.example.MamaCare.DTO;

import com.example.MamaCare.model.Doctor;

import com.example.MamaCare.model.Patient;

import com.example.MamaCare.model.Appointment;

import java.time.LocalDate;

public record ClinicDTO(
    Long id,
    String name,
    LocalDate joinedAt,
    String Location,
    Doctor doctor,
    Patient patient,
    Appointment appointment
    ){}
