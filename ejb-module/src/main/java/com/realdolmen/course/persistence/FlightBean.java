package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by SVCAX33 on 16/09/2015.
 */
@Stateless
@LocalBean
public class FlightBean implements FlightBeanRemote{

    @PersistenceContext
    private EntityManager em;

    public FlightBean() {
    }


    public List<Flight> findFlights(){
        TypedQuery<Flight> query = em.createNamedQuery(Flight.FIND_ALL, Flight.class);
        return query.getResultList();
    }

    public Flight findFlightById(int id){
        TypedQuery<Flight> query = em.createNamedQuery(Flight.FIND_BY_ID, Flight.class);
        query.setParameter(":id", id);
        return query.getSingleResult();
    }
}
