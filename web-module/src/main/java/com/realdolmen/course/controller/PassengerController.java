package com.realdolmen.course.controller;

import com.realdolmen.course.domain.*;
import com.realdolmen.course.persistence.BookRepository;
import com.realdolmen.course.persistence.FlightBean;
import com.realdolmen.course.persistence.PassengerStatelessBean;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by SVCAX33 on 15/09/2015.
 */

@Named
@ConversationScoped
public class PassengerController implements Serializable{
    @Inject
    PassengerStatelessBean passengerBean;

    @PersistenceContext
    EntityManager em;

    @NotNull @Size(min=1) private String country;
    @NotNull private String ssn;
    @NotNull @Size(min=1) private String firstName;
    @NotNull private String lastName;
    @NotNull private int frequentFlyerMiles;
    @NotNull @Past private Date dateOfBirth;
    @NotNull private PassengerType type;
    @NotNull private String street1;
    @NotNull private String street2;
    @NotNull private String city;
    @NotNull private String state;
    @NotNull private String zipcode;
    @NotNull private int price;
    private int flightId;

    public List<Passenger> getAllPassengers() {
        return passengerBean.findPassengers();
    }

    public void remove(int passengerId) {
        passengerBean.deletePassenger(passengerId);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(int frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PassengerType getType() {
        return type;
    }

    public void setType(PassengerType type) {
        this.type = type;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void bookTicket(@Observes String event){
        Ticket ticket = new Ticket(price);
        ticket.setFlight(em.find(Flight.class, flightId));
        Passenger passenger = new Passenger(ssn, firstName, lastName, frequentFlyerMiles, dateOfBirth, type, street1, street2, city, state, zipcode, country);
        ticket.setPassenger(passenger);
        passengerBean.bookTicket(ticket);

    }
}
