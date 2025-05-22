package com.example.MamaCare.controller;

import com.example.MamaCare.model.Doctor;

import com.example.MamaCare.repositories.DoctorRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController{
    private final DoctorRepository operation;

    public DoctorController(DoctorRepository operation){
        this.operation = operation;
    }

    //Create a doctor entity
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return operation.save(doctor);
    }

    //Gives a List of all Doctors
    @GetMapping
    public List<Doctor> getListOfDoctors(){
        return operation.findAll();
    }

    //Finds a single Doctor entity by id
    @GetMapping("/id")
    public Optional<Doctor> getDoctorById(@PathVariable Long id){
        return operation.findById(id);
    }

    //Updates a Doctor entity by id
    @PutMapping("/id")
    public Optional<Doctor> updateDoctor(@RequestBody Doctor updateDoctor,
            @PathVariable Long id){
                return operation.findById(id).map(doctor ->{
                    doctor.setFirstName(updateDoctor.getFirstName());
                    doctor.setLastName(updateDoctor.getLastName());
                    doctor.setEmail(updateDoctor.getEmail());
                    doctor.setAvailable(updateDoctor.getAvailable());
                    doctor.setPhoneNumber(updateDoctor.getPhoneNumber());
                    doctor.setPatient(updateDoctor.getPatient());
                    doctor.setClinic(updateDoctor.getClinic());
                    doctor.setAppointment(updateDoctor.getAppointment());
                    
                    Doctor saveDoctor = new Doctor();

                    return operation.save(saveDoctor); 
                });
    }

    //Delete Doctor entity by id
    @DeleteMapping("/id")
    public void deleteDoctor(@PathVariable Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }
}
