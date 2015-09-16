package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;

import java.util.List;

/**
 * Created by SVCAX33 on 16/09/2015.
 */
public interface FlightBeanRemote {
    List<Flight> findFlights();

    Flight findFlightById(int id);
}
