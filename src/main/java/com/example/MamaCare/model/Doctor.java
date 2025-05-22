package com.example.MamaCare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

import java.util.ArrayList;


@Entity
@Table(name="Doctor")
public class Doctor{
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", nullable=false)
    @Id
    private Long id;

    @Column(name="First Name", nullable = false)
    @NotNull(message="First Name cannot be null!")
    @NotEmpty(message="First Name cannot be empty")
    @Size(min=3, max=30, message="Name should be between 3-30 characters!")
    private String firstName;

    @Column(name="Last Name", nullable = false)
    @NotNull(message="Last Name cannot be null!")
    @NotEmpty(message="Last Name cannot be empty")
    @Size(min=3, max=30, message="Name should be between 3-30 characters!")
    private String lastName;

    @Column(name = "PhoneNumber", nullable = false)
    @NotNull(message="Field cannot be null!")
    @Size(min=10,max=10, message="Phone Number length should be 10characters!")
    private int phoneNumber;

    @Column(name = "Email", nullable = false)
    @Email(message="Should be a valid email!")
    private String email;

    @Column(name="Availability", nullable=false)
    @NotNull(message= "Should be true or false")
    private Boolean available;

    //private Patient patient;
 
    //private Clinic clinic;

    @OneToMany(mappedBy="doctor")
    private List<Appointment> appointments = new ArrayList();

    public Doctor(){}

    public Doctor(Long id, String firstName, String lastName, int phoneNumber, String email, Boolean available,
            /*Patient patient, Clinic clinic,*/ List<Appointment> appointments){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.available = available;
        /*
            this.patient = patient;
            this.clinic = clinic;
        */
        this.appointments = appointments;
    }

    // Getters
    public Long getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getEmail(){
        return this.email;
    }

    public Boolean getAvailable(){
        return this.available;
    }

    /*public Patient getPatient(){
        return this.patient;
    }

    public Clinic getClinic(){
        return this.clinic;
    }
    */


    public List<Appointment> getAppointment(){
        return this.appointments;
    }

    //setters

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAvailable(Boolean available){
        this.available = available;
    }

    /*public void setPatient(Patient patient){
        this.patient = patient;
    }

    public void setClinic(Clinic clinic){
        this.clinic = clinic;
    }
    */
    public void setAppointment(List<Appointment> appointments){
        this.appointments = appointments;
    }
}
