package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.persistence.FlightBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by SVCAX33 on 16/09/2015.
 */

@Named
@RequestScoped
public class FlightController {

    @Inject
    FlightBean flightBean;


    public List<Flight> getAllFlights(){
        return flightBean.findFlights();
    }

    public Flight getFlight(int id){
        return flightBean.findFlightById(id);
    }
}
