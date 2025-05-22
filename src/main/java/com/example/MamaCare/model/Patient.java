package com.example.MamaCare.model;

import jakarta.validation.constraints.*;

import jakarta.persistence.*;

import org.hibernate.validator.constraints.URL;

import java.util.List;

import java.util.ArrayList;

import java.time.LocalDate;

@Entity
@Table(name="Patient")
public class Patient{
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", nullable=false)
    @Id
    private Long id;

    @Column(name="FirstName", nullable=false)
    @NotNull(message="First Name cannot be empty!")
    @NotBlank(message="First Name cannot be empty!")
    @Size(min=3, max=30, message="The name should be between 3-30 characters!")
    private String firstName;


    @Column(name="LastName", nullable=false)
    @NotNull(message="Last Name cannot be empty!")
    @NotBlank(message="Last Name cannot be empty!")
    @Size(min=3, max=30, message="The name should be between 3-30 characters!")
    private String lastName;

    @Column(name="Email", nullable=false)
    @Email
    @NotNull(message="Email cannot be empty!")
    @NotBlank(message="Email cannot be empty!")
    @Size(min=3, max=30, message="The email should be between 3-30 characters!")
    private String email;

    @Column(name="Address", nullable=true)
    @Size(max=2048, message="Url should not exceed 2048!")
    @URL(protocol="https", message="Must be a valid URL!")
    private String address;

    @Column(name="Spouce", nullable=false)
    @NotNull(message="Feild must be true or false!")
    private Boolean spouce;
    
    @Column(name="PhoneNumber", nullable=false)
    @Positive
    @Size(max=10)
    private int phoneNumber;

    @Column(name="Age", nullable=false)
    @Past
    private LocalDate age;

    
    @Column(name="DueDate", nullable=false)
    @Future
    private LocalDate dueDate;

    @Column(name="Preexisting Condition")
    @NotNull(message="Should be true or false!")
    private Boolean preCondition;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors = new ArrayList();
    
    @ManyToOne
    @JoinColumn(name="clinic_id")
    private Clinic clinic;

    @OneToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    public Patient(){}

    public Patient(Long id, String firstName, String lastName, String email, String address,
                    Boolean spouce, int phoneNumber, LocalDate age, LocalDate dueDate, Boolean preCondition,
                    Clinic clinic,  Appointment appointment, List<Doctor> doctors){
        
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.spouce = spouce;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.dueDate = dueDate;
        this.preCondition = preCondition;
        this.doctors = doctors;
        this.clinic = clinic;
        this.appointment = appointment;
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

    public String getEmail(){
        return this.email;
    }

    public LocalDate getAge(){
        return this.age;
    }

    public String getAddress(){
        return this.address;
    }

    public Boolean getSpouce(){
        return this.spouce;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public LocalDate getDueDate(){
        return this.dueDate;
    }
    
    public Boolean getPreCondition(){
        return this.preCondition;
    }

    public List<Doctor> getDoctor(){
        return this.doctors;
    }

    public Clinic getClinic(){
        return this.clinic;
    }

    public Appointment getAppointment(){
        return this.appointment;
    }

    //Setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setAge(LocalDate age){
        this.age = age;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setSpouce(Boolean spouce){
        this.spouce = spouce;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }
    
    public void setPreCondition(Boolean preCondition){
        this.preCondition = preCondition;
    }

    
    public void setDoctor(List<Doctor> doctors){
        this.doctors = doctors;
    }

    public void setClinic(Clinic clinic){
        this.clinic = clinic;
    }

    public void setAppointment(Appointment appointment){
        this.appointment = appointment;
    }
}

