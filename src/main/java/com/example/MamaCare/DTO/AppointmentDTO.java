package com.example.MamaCare.DTO;

import java.time.LocalDate;

public record AppointmentDTO(
        Long id,
        LocalDate time,
        Boolean status
        ){}
