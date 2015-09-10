package com.realdolmen.course;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by SVCAX33 on 9/09/2015.
 */

@Entity
public class Passenger implements Serializable {

    @Id
    @GeneratedValue()
    private Integer id;

    @Basic(optional = false)

    @Column(nullable = false, updatable = false)
    private String ssn;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;
    private byte[] picture;

    @Column(nullable=false, updatable=false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Transient
    private int age;

    @Enumerated()
    @Column(nullable=false)
    private PassengerType passengerType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;

    private Integer frequentFlyerMiles;

    @Embedded
    @Column(nullable=false)
    private Address address;

    @Embedded
    @Column(nullable=true)
    private CreditCard creditCard;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name="preferences")
    @Column(name="preferences")
    private List<String> preferences = new ArrayList<String>();

    protected Passenger(){}

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth, PassengerType type, String street1, String street2, String city, String state, String zipcode, String country){
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.dateOfBirth = dateOfBirth;
        this.passengerType = type;
        lastFlight = Timestamp.from(Instant.now());
        address = new Address(street1, street2, city, state, zipcode, country);
    }

    public Integer getId() {
        return id;
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

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        int agecalc = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if(today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
        agecalc--;
        return agecalc;
    }

    public void setAge(int age) {
        this.age = 10;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

}


