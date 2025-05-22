package com.example.MamaCare.DTO;

import com.example.MamaCare.model.Clinic;

import com.example.MamaCare.model.Patient;

import com.example.MamaCare.model.Appointment;

public record DoctorDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        Boolean available,
        int phoneNumber,
        Clinic clinic,
        Patient patient,
        Appointment appointment
        ){}
