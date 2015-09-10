package com.realdolmen.course;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by SVCAX33 on 10/09/2015.
 */

@Entity
public class InternationalFlight extends Flight {

    private Boolean blacklisted;

    private String regulations;

    private String airlineCompany;

    public InternationalFlight(String number, Date departureTime, Date arrivalTime, String airlineCompany, Boolean blacklisted, String regulations) {
        super(number, departureTime, arrivalTime);
        this.blacklisted = blacklisted;
        this.regulations = regulations;
        this.airlineCompany = airlineCompany;
    }

    protected InternationalFlight(){}

    public Boolean getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }
}
