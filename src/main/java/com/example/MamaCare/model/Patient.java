package com.example.MamaCare.model;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;


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

    public Patient(Long id, String firstName, String lastName, String email, String address,
                    Boolean spouce, int phoneNumber, LocalDate age, LocalDate dueDate, Boolean preCondition){
        
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
    }

    public Patient(){}

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
}

