package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SVCAX33 on 10/09/2015.
 */

@Entity
@NamedQueries({
        @NamedQuery(name=Flight.FIND_ALL, query = "select c from Flight c"),
        @NamedQuery(name=Flight.FIND_BY_ID, query = "select c from Flight c where c.id = :id")
})

public abstract class Flight extends AbstractEntity {

    public static final String FIND_ALL = "Flight.findAll";
    public static final String FIND_BY_ID = "Flight.findById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String number;

    @Column (nullable = false)
    private Date departureTime;

    @Column (nullable = false)
    private Date arrivalTime;


    protected Flight(String number, Date departureTime, Date arrivalTime) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    protected Flight(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
