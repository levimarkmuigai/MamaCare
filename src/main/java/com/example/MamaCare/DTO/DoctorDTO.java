package com.example.MamaCare.DTO;

public record DoctorDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        Boolean available,
        int phoneNumber
        ){}
