package com.example.MamaCare.controller;

import com.example.MamaCare.model.Clinic;

import com.example.MamaCare.repositories.ClinicRepository;

import java.util.List;

import java.util.Optional;

public class ClinicController{
   private final ClinicRepository operation;

   public ClinicController(ClinicRepository operation){
        this.operation = operation;
   }

   // Create a Clinic entity
   public Clinic createClinic(Clinic clinic){
        return operation.save(clinic);
   }

   // List all Clinic's
   public List<Clinic> fetchClinicList(){
        return operation.findAll();
   }

   //Find a single Clinic by id
   public Optional<Clinic> fetchClinicById(Long id){
       return operation.findById(id);
    }

   //Update existing Clinic entity by id
   public Optional<Clinic> updateClinic(Clinic updateClinic, Long id){
        return operation.findById(id).map(clinic -> {
            clinic.setName(updateClinic.getName());
            clinic.setJoinedAt(updateClinic.getJoinedAt());
            clinic.setLocation(updateClinic.getLocation());

            Clinic saveClinic = operation.save(clinic);

            return saveClinic;
        });
   }

   // Delete Clinic entity by id
   public void deleteClinicById(Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
   }
}
