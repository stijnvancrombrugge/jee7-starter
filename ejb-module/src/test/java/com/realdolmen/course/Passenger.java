package com.realdolmen.course;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SVCAX33 on 9/09/2015.
 */

@Entity
public class Passenger implements Serializable {

    @Id
    @GeneratedValue()
    private Integer id;

    @Basic(optional=false)

    private String ssn;
    private String firstName;
    private String lastName;

    private Integer frequentFlyerMiles;

    protected Passenger(){}

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles){
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequentFlyerMiles = frequentFlyerMiles;
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
}
