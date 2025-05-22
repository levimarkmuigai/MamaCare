package com.example.MamaCare.DTO;

import java.time.LocalDate;

public record ClinicDTO(
    Long id,
    String name,
    LocalDate joinedAt,
    String Location
    ){}
