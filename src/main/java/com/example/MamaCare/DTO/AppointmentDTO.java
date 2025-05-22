package com.example.MamaCare.DTO;

import java.time.LocalDate;

import com.example.MamaCare.model.Doctor;

import com.example.MamaCare.model.Patient;

import com.example.MamaCare.model.Clinic;

public record AppointmentDTO(
        Long id,
        LocalDate time,
        Boolean status,
        Doctor doctor,
        Patient patient,
        Clinic clinic
        ){}
