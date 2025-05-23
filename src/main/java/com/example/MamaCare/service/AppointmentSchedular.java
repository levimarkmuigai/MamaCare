package com.example.MamaCare.service;

import com.example.MamaCare.model.Appointment;

import com.example.MamaCare.repositories.AppointmentRepository;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.*;

import java.util.List;

public class AppointmentSchedular{

    private final AppointmentRepository schedular;

    private final LocalDate today = LocalDate.now();

    private final Appointment newAppointment;

    public AppointmentSchedular(AppointmentRepository schedular, Appointment newAppointment){
        this.schedular = schedular;
        this.newAppointment = newAppointment;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void processAppointment(){
       newAppointment.setNextAppointment(newAppointment.getInitialAppointment().plusWeeks(4));

       schedular.save(newAppointment);
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void processDueAppointments(){

       List <Appointment> dueAppointments = schedular.findByNextAppointment(today);

       for(Appointment dueAppointment : dueAppointments){
            dueAppointment.setNextAppointment(dueAppointment.getNextAppointment().plusWeeks(4));

            schedular.save(dueAppointment);
       } 
    }
}
