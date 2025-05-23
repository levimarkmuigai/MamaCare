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

    @Column(name="initial_appointment", nullable = true)
    private LocalDate initialAppointment;

    @Column(name="current_appointment", nullable = false)
    @NotNull(message="Current Appointment cannot be null!")
    private LocalDate currentAppointment;

    @Column(name="next_appointment", nullable = false)
    @NotNull(message="Next appointment cannot be null!!")
    private LocalDate nextAppointment;

    public Appointment(){}

    public Appointment(Long id, LocalDate initialAppointment, LocalDate currentAppointment, LocalDate nextAppointment){
        
        this.id = id;
        this.initialAppointment = initialAppointment;
        this.currentAppointment = currentAppointment;
        this.nextAppointment = nextAppointment;
    }

    //Getters
    public Long getId(){
        return this.id;
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

    //setters 
    public void setId(Long id){
        this.id = id;
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
}
