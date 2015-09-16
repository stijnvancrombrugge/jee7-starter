package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SVCAX33 on 10/09/2015.
 */

@Entity
@NamedQuery(name=Ticket.FIND_ALL, query = "select c from Ticket c")
public class Ticket implements Serializable {

    public static final String FIND_ALL = "Ticket.findAll";
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
