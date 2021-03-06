package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by SVCAX33 on 11/09/2015.
 */

@Stateless
@LocalBean
public class PassengerStatelessBean implements PassengerStatelessBeanRemote {

    @PersistenceContext
    private EntityManager em;

    public List<Passenger> findPassengers() {
        TypedQuery<Passenger> query = em.createNamedQuery(Passenger.FIND_ALL, Passenger.class);
        return query.getResultList();
    }


    public Passenger findPassengersById(int id){
        return em.find(Passenger.class, id);
    }

    public void createPassenger(Passenger passenger) {
        em.persist(passenger);
    }

    public void deletePassenger(int passengerId){
        em.remove(em.getReference(Passenger.class, passengerId));
    }

    public Passenger updatePassenger(Passenger passenger){
        return em.merge(passenger);
    }

    public void bookTicket(Ticket ticket){
        em.persist(ticket);
    }
}
