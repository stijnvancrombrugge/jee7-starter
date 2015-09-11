package com.realdolmen.course.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by SVCAX33 on 9/09/2015.
 */

@EntityListeners(PassengerListener.class)
@Entity
@NamedQueries({
        @NamedQuery(name=Passenger.FIND_ALL, query = "select c from Passenger c"),
        @NamedQuery(name=Passenger.FIND_ALL_LASTNAMES, query="select c.lastName from Passenger c"),
        @NamedQuery(name=Passenger.TOTAL_FREQUENT_FLYERMILES, query="select sum(c.frequentFlyerMiles) from Passenger c"),
        @NamedQuery(name=Passenger.FIND_TICKETS_BY_PASSENGERID,query="select c.ticketList from Passenger c where c.id = :searchid"),
        @NamedQuery(name=Passenger.DELETE_ALL,query="delete from Passenger")

})
public class Passenger implements Serializable {

    public static final String FIND_ALL = "Passenger.findAll";
    public static final String FIND_ALL_LASTNAMES = "Passenger.findAllLastnames";
    public static final String TOTAL_FREQUENT_FLYERMILES = "Passenger.totalFrequentFlyermiles";
    public static final String FIND_TICKETS_BY_PASSENGERID = "Passenger.findTicketsByPassengerid";
    public static final String DELETE_ALL = "Passenger.deleteAll";


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

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastUpdated;

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


    @OneToMany
    private List<Ticket> ticketList;


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

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }
}


