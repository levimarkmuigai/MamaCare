package com.example.MamaCare.DTO;

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
        Boolean preCondition
        ){}
