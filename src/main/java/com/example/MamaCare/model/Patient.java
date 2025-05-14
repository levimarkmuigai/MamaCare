package com.example.MamaCare.model;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;

import com.example.MamaCare.MicroService.GenerateId.*;

import java.util.Date;

@Entity
@Table(name="Patient")
public class Patient{
    
    @Column(name="Id", nullable=false)
    @NotNull
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
    private Date age;

    
    @Column(name="DueDate", nullable=false)
    @Future
    private Date dueDate;

    @Column(name="Preexisting Condition")
    @NotNull(message="Should be true or false!")
    private Boolean preCondition;

    public Patient(Long id, String firstName, String lastName, String email, String address,
                    Boolean spouce, int phoneNumber, Date age, Date dueDate, Boolean preCondition){
        
        this.id = (id != null) ? id : new GenerateId.generateId();
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

    public Date getAge(){
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

    public Date getDueDate(){
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

    public void age(Date age){
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

    public void getDueDate(Date dueDate){
        this.dueDate = dueDate;
    }
    
    public void getPreCondition(Boolean preCondition){
        this.preCondition = preCondition;
    }
}

