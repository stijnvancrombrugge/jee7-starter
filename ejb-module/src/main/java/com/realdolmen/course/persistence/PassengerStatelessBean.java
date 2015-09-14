package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
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
        return em.find(Passenger.class,id);
    }

    public Passenger createPassenger(Passenger passenger) {
        em.persist(passenger);
        return passenger;
    }

    public void deletePassenger(Passenger passenger){
        em.remove(em.merge(passenger));
    }

    public Passenger updatePassenger(Passenger passenger){
        return em.merge(passenger);
    }
}
