package com.example.MamaCare.controller;

import com.example.MamaCare.model.Clinic;

import com.example.MamaCare.repositories.ClinicRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController{
   private final ClinicRepository operation;

   public ClinicController(ClinicRepository operation){
        this.operation = operation;
   }

   // Create a Clinic entity
   @PostMapping
   public Clinic createClinic(@RequestBody Clinic clinic){
        return operation.save(clinic);
   }

   // List all Clinic's
   @GetMapping
   public List<Clinic> fetchClinicList(){
        return operation.findAll();
   }

   //Find a single Clinic by id
   @GetMapping("/id")
   public Optional<Clinic> fetchClinicById(@PathVariable Long id){
       return operation.findById(id);
    }

   //Update existing Clinic entity by id
   @PutMapping("/id")
   public Optional<Clinic> updateClinic(@RequestBody Clinic updateClinic, 
           @PathVariable Long id){
        return operation.findById(id).map(clinic -> {
            clinic.setName(updateClinic.getName());
            clinic.setJoinedAt(updateClinic.getJoinedAt());
            clinic.setLocation(updateClinic.getLocation());
            clinic.setDoctor(updateClinic.getDoctor());
            clinic.setPatient(updateClinic.getPatient());
            clinic.setAppointment(updateClinic.getAppointment());

            Clinic saveClinic = operation.save(clinic);

            return saveClinic;
        });
   }

   // Delete Clinic entity by id
   @DeleteMapping("/id")
   public void deleteClinicById(@PathVariable Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
   }
}
