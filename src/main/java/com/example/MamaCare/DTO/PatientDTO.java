package com.example.MamaCare.DTO;

import com.example.MamaCare.model.Doctor;

import com.example.MamaCare.model.Clinic;

import com.example.MamaCare.model.Appointment;

import java.time.LocalDate;

public record PatientDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String address,
        Boolean spouce,
        int phoneNumber,
        LocalDate age,
        LocalDate dueDate,
        Boolean preCondition,
        Doctor doctor,
        Clinic clinic,
        Appointment appointment
        ){}
