package com.realdolmen.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * Created by SVCAX33 on 10/09/2015.
 */

@Entity
public class DomesticFlight extends Flight {

    private String airlineCompany;

    @Column(name = "flight_references")
    private String references;

    public DomesticFlight(String number, Date departureTime, Date arrivalTime, String airlineCompany, String references) {

        super(number, departureTime, arrivalTime);
        this.airlineCompany = airlineCompany;
        this.references = references;
    }

    protected DomesticFlight(){}

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
}
