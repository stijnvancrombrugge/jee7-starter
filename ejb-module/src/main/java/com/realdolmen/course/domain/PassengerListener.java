package com.realdolmen.course.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SVCAX33 on 11/09/2015.
 */


public class PassengerListener implements Serializable{

    @PrePersist
    @PreUpdate
    private void updateLastUpdated(Passenger passenger){
        passenger.setDateLastUpdated(new Date());
    }


    @PostLoad
    @PostPersist
    @PostUpdate
    private void calculateAge(Passenger passenger){
        passenger.setAge(passenger.getAge());
    }
}
