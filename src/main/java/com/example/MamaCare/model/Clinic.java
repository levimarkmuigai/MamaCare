package com.example.MamaCare.model;


import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.URL;


import com.example.MamaCare.MicroService.GenerateId.*;

import java.util.Date;

/* Clinic Table*/

@Entity
@Table(name = "Clinic")
public class Clinic{
   
    @Column(name="id", nullable=false)
    private Long id;

    @Column(name="Name", nullable=false)
    @Size(min=10, max=250, message="The name should be between 10 - 250 characters!")
    @NotBlank(message="Clinic name should not be blank!")
    @NotNull(message="Clinic name cannot be empty!")
    private String name;

    @Column(name="Joined At", nullable=false)
    @PastOrPresent
    private Date joinedAt;

    @Column(name="Location", nullable=false)
    @Size(max=2048, message="Location cannot be more than 2048characters!")
    @NotBlank(message="Location cannot be blank!")
    @URL(protocol="https", message="Must be a valid URL.")
    private String location;

    public Clinic(Long id, String name, Date joinedAt, String location){
        this.id = (id != null) ? id : new GenerateId().generateId(); 
        this.name = name;
        this.joinedAt = joinedAt;
        this.location = location;
    }

    // Constractor Required by JPA
    public Clinic(){}

    // Getters
    
     public Long getId(){

        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Date getJoinedAt(){
        return this.joinedAt;
    }

    public String getLocation(){
        return this.location;
    }

    //setters

     public void setId(Long id){
        this.id = id;
     }
    public void setName(String name){
        this.name = name;
    }

    public void setJoinedAt(Date joinedAt){
        this.joinedAt = joinedAt;
    }

    public void setLocation(String location){
        this.location = location;
    }

   

}
