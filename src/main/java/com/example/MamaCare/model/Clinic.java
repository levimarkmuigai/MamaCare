package com.example.MamaCare.model;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;

import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

import java.util.List;

import java.util.ArrayList;

/* Clinic Table*/

@Entity
@Table(name = "Clinic")
public class Clinic{
   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    @Id
    private Long id;

    @Column(name="Name", nullable=false)
    @Size(min=10, max=250, message="The name should be between 10 - 250 characters!")
    @NotBlank(message="Clinic name should not be blank!")
    @NotNull(message="Clinic name cannot be empty!")
    private String name;

    @Column(name="Joined At", nullable=false)
    @PastOrPresent
    private LocalDate joinedAt;

    @Column(name="Location", nullable=false, unique = true)
    @Size(max=2048, message="Location cannot be more than 2048characters!")
    @NotBlank(message="Location cannot be blank!")
    @URL(protocol="https", message="Must be a valid URL.")
    private String location;

    @OneToMany(mappedBy="clinic")
    private List<Doctor> doctors = new ArrayList();

    @OneToMany(mappedBy="clinic")
    private List<Patient> patients = new ArrayList();

    @OneToMany(mappedBy="clinic")
    private List<Appointment> appointments = new ArrayList();

    public Clinic(Long id, String name, LocalDate joinedAt, String location, 
            List<Doctor> doctors, List<Patient> patients, List<Appointment> appointments){
        this.id = id;
        this.name = name;
        this.joinedAt = joinedAt;
        this.location = location;
        this.doctors = doctors;
        this.patients = patients;
        this.appointments = appointments;
    }
  
     // Constructor Required by JPA
    public Clinic(){}

    // Getters
    
     public Long getId(){

        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getJoinedAt(){
        return this.joinedAt;
    }

    public String getLocation(){
        return this.location;
    }

    public List<Doctor> getDoctor(){
        return this.doctors;
    }

    public List<Patient> getPatient(){
        return this.patients;
    }

    public List<Appointment> getAppointment(){
        return this.appointments;
    }

    //setters
    
    public void setName(String name){
        this.name = name;
    }

    public void setJoinedAt(LocalDate joinedAt){
        this.joinedAt = joinedAt;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void setDoctor(List<Doctor> doctors){
        this.doctors = doctors;
    }

    public void setPatient(List<Patient> patients){
        this.patients = patients;
    }

    public void setAppointment(List<Appointment> appointments){
        this.appointments = appointments;
    }
}
