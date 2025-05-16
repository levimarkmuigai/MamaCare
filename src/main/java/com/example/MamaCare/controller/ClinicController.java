package com.example.MamaCare.controller;

import com.example.MamaCare.model.Clinic;

import com.example.MamaCare.repositories.ClinicRepository;

public class ClinicController{
   private final ClinicRepository operation;

   public ClinicController(ClinicRepository operation){
        this.operation = operation;
   }
}
