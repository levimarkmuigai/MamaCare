package com.example.MamaCare.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

// Appointment Table
@Entity
public class Appointment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="time", nullable = false)
    @PastOrPresent
    @NotNull(message="Time cannot be null!")
    private LocalDate time;

    @Column(name="status", nullable = false)
    @NotNull(message="Status cannot be empty!")
    private Boolean status;
 
    //private Patient patient;
 
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
 
    //private Clinic clinic;

    public Appointment(){}

    public Appointment(Long id, LocalDate time, Boolean status
            /*Doctor doctor, Patient patient, Clinic clinic*/){
        
        this.id = id;
        this.time = time;
        this.status = status;
        /*this.doctor = doctor;
        this.patient = patient;
        this.clinic = clinic;*/
    }

    // Getters
    public Long getId(){
        return this.id;
    }

    public LocalDate getTime(){
        return this.time;
    }

    public Boolean getStatus(){
        return this.status;
    }

    /*public Doctor getDoctor(){
        return this.doctor;
    }

    public Patient getPatient(){
        return this.patient;
    }

    public Clinic getClinic(){
        return this.clinic;
    }*/

    //setters
    public void setTime(LocalDate time){
        this.time = time;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

     /*public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void getPatient(Patient patient){
        this.patient = patient;
    }

    public void setClinic(Clinic clinic){
        this.clinic = clinic;
    }*/
}
