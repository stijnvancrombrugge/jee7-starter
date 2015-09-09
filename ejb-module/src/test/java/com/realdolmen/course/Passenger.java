package com.realdolmen.course;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SVCAX33 on 9/09/2015.
 */

@Entity
@Table(name="passenger")
@SecondaryTables({
        @SecondaryTable(name="person_info")
})
public class Passenger implements Serializable {

    @EmbeddedId
    private PassengerId passengerId;

    @Basic(optional=false)

    private String firstName;

    @Column(table="person_info")
    private Integer frequentFlyerMiles;

    @Column(table="person_info")
    @Basic(fetch=FetchType.LAZY)
    private byte[] picture;

    protected Passenger(){}

    public Passenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles){
        this.firstName = firstName;
        this.frequentFlyerMiles = frequentFlyerMiles;
        this.passengerId = new PassengerId(ssn, lastName);
    }

    public PassengerId getPassengerId() {
        return passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }
}
