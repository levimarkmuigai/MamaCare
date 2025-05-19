package com.example.MamaCare.controller;

import com.example.MamaCare.model.Patient;

import com.example.MamaCare.repositories.PatientRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController{

    private final PatientRepository operation;

    public PatientController(PatientRepository operation){
        this.operation = operation;
    }

    // Create a Patient entity
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        return operation.save(patient);
    }

    // Return a list of all Patient entities
    @GetMapping
    public List<Patient> getPatientsList(@RequestBody Patient patient){
        return operation.findAll();
    }

    // Find a patient using an Id
    @GetMapping("/id")
    public Optional<Patient> getPatientById(@PathVariable Long id){
        return operation.findById(id);
    }

    // Upddate patient entity using id
    @PutMapping
    public Optional<Patient> updatePatient(@RequestBody Patient updatePatient,
            @RequestBody Long id){
                return operation.findById(id).map(patient ->{
                    patient.setFirstName(updatePatient.getFirstName());
                    patient.setLastName(updatePatient.getLastName());
                    patient.setEmail(updatePatient.getEmail());
                    patient.setPhoneNumber(updatePatient.getPhoneNumber());
                    patient.setSpouce(updatePatient.getSpouce());
                    patient.setAddress(updatePatient.getAddress());
                    patient.setAge(updatePatient.getAge());
                    patient.setDueDate(updatePatient.getDueDate());
                    patient.setPreCondition(updatePatient.getPreCondition());

                    Patient savePatient = new Patient();

                    return operation.save(savePatient);
                });
    }

    // Delete Doctor Entity by id
    @DeleteMapping("/id")
    public void deletePatientById(@PathVariable Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }
    
}
