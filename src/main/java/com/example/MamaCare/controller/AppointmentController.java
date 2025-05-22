package com.example.MamaCare.controller;

import org.springframework.web.bind.annotation.*;

import com.example.MamaCare.model.Appointment;

import com.example.MamaCare.repositories.AppointmentRepository;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController{
    
    private final AppointmentRepository operation;

    public AppointmentController(AppointmentRepository operation){
        this.operation = operation;
    }

    // Create an Appointment Entity
    @PostMapping
    public Appointment createAppointment(@RequestParam Appointment appointment){
        return operation.save(appointment);
    }

    // List All Appointments
    @GetMapping
    public List<Appointment> getAllAppointments(){
        return operation.findAll();
    }

    // Get a single Appointment using the Id
    @GetMapping("/id")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id){
        return operation.findById(id);
    }

    // Update an Appointment by id
    @PutMapping("/id")
    public Optional<Appointment> updateAppointment(@RequestParam Appointment updateAppointment,
            @PathVariable Long id){
    
            return operation.findById(id).map(appointment ->{
                appointment.setTime(updateAppointment.getTime());
                appointment.setStatus(updateAppointment.getStatus());
                appointment.setDoctor(updateAppointment.getDoctor());
                appointment.setPatient(updateAppointment.getPatient());
                appointment.setClinic(updateAppointment.getClinic());

                Appointment saveAppointment = new Appointment();

                return operation.save(saveAppointment);
            });
    }

    // Delete appointment by id
    @DeleteMapping("/id")
    public void deleteAppointmentById(@PathVariable Long id){
        if(operation.existsById(id)){
            operation.deleteById(id);
        }
    }


}
