package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.*;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by SVCAX33 on 14/09/2015.
 */

@Stateful
@Remote
public class PassengerStatefulBean implements PassengerStatefulBeanRemote{

    private Passenger passenger;

    @PersistenceContext
    private EntityManager em;

    public PassengerStatefulBean() {
    }

    public void addPassenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth, PassengerType type, String street1, String street2, String city, String state, String zipcode, String country) {
        this.passenger = new Passenger(ssn, firstName, lastName, frequentFlyerMiles, dateOfBirth, type, street1, street2, city, state, zipcode, country);
    }

    public void addAddress(Address address){
        passenger.setAddress(address);
    }

    public void addCreditCard(CreditCard creditCard){
        passenger.setCreditCard(creditCard);
    }

    public void addTicket(int price){
        Ticket ticket = new Ticket(price);
        passenger.addTicket(ticket);
    }

    @Remove
    public void checkout(){
        em.persist(passenger);
    }

}
