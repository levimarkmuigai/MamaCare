package com.example.MamaCare.model;

import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;

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
}

