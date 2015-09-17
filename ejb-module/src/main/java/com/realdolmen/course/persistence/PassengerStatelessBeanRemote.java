package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

/**
 * Created by SVCAX33 on 11/09/2015.
 */

@Remote
public interface PassengerStatelessBeanRemote extends Serializable {
    List<Passenger> findPassengers();
    Passenger findPassengersById(int id);
    void createPassenger(Passenger passenger);
    void deletePassenger(int passengerId);
    Passenger updatePassenger(Passenger passenger);
}
