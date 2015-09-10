package com.realdolmen.course;

import javax.persistence.*;
import java.util.List;

/**
 * Created by SVCAX33 on 10/09/2015.
 */

@Entity
public class Ticket {
    private double price;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Flight flight;

    @ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;

    protected Ticket(){}

    public Ticket(double price){
        if(price<0){
            throw new IllegalArgumentException("Price is lower than 0");
        }
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
