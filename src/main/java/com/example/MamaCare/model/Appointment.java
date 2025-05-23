package com.example.MamaCare.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

// Appointment Table
@Entity
public class Appointment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="appointmentDate")
    private LocalDate date;

    @Column(name="initial_appointment", nullable = true)
    private LocalDate initialAppointment;

    @Column(name="current_appointment", nullable = false)
    @NotNull(message="Current Appointment cannot be null!")
    private LocalDate currentAppointment;

    @Column(name="next_appointment", nullable = false)
    @NotNull(message="Next appointment cannot be null!!")
    private LocalDate nextAppointment;


    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "patient_id)")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Appointment(){}

    public Appointment(Long id, LocalDate initialAppointment, LocalDate currentAppointment, LocalDate nextAppointment,
            Patient patient, Clinic clinic, Doctor doctor, LocalDate date){
        
        this.id = id;
        this.initialAppointment = initialAppointment;
        this.currentAppointment = currentAppointment;
        this.nextAppointment = nextAppointment;
        this.patient = patient;
        this.clinic = clinic;
        this.doctor = doctor;
        this.date = date;
    }

    //Getters
    public Long getId(){
        return this.id;
    }

    public LocalDate getDate(){
        return this.date;
    }
    public LocalDate getInitialAppointment(){
        return this.initialAppointment;
    }

    public LocalDate getCurrentAppointment(){
        return this.currentAppointment;
    }

    public LocalDate getNextAppointment(){
        return this.nextAppointment;
    }

    public Clinic getClinic(){
        return this.clinic;
    }

    public Doctor getDoctor(){
        return this.doctor;
    }

    public Patient getPatient(){
        return this.patient;
    }

    //setters 
    public void setId(Long id){
        this.id = id;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public void setInitialAppointment(LocalDate initialAppointment){
       this.initialAppointment = initialAppointment; 
    }

    public void setCurrentAppointment(LocalDate currentAppointment){
        this.currentAppointment = currentAppointment;
    }

    public void setNextAppointment(LocalDate nextAppointment){
        this.nextAppointment = nextAppointment;
    }

    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public void setClinic(Clinic clinic){
        this.clinic = clinic;
    }
}
