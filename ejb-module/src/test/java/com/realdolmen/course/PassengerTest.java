package com.realdolmen.course;

import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by SVCAX33 on 11/09/2015.
 */
public class PassengerTest extends DataSetPersistenceTest {

    @Test
    public void findAllTest() throws Exception{
        makeNewPassenger();
        TypedQuery<Passenger> query = entityManager().createNamedQuery(Passenger.FIND_ALL,Passenger.class);
        List<Passenger> passengerList = query.getResultList();
        assertEquals("Tim", passengerList.get(1).getFirstName());
    }

    @Test
    public void deleteAllTest() throws Exception{
        makeNewPassenger();
        entityManager().createNamedQuery(Passenger.DELETE_ALL).executeUpdate();
        TypedQuery<Passenger> query = entityManager().createNamedQuery(Passenger.FIND_ALL,Passenger.class);
        List<Passenger> passengerList = query.getResultList();
        assertEquals(0,passengerList.size());
    }

    @Test
    public void totalFlyermilesTest() throws Exception{
        makeNewPassenger();
        TypedQuery<Long> query = entityManager().createNamedQuery(Passenger.TOTAL_FREQUENT_FLYERMILES, Long.class);
        long totalFlyerMiles = query.getSingleResult();
        assertEquals(110, totalFlyerMiles);
    }

    @Test
    public void getTickesByPassengeridTest() throws Exception{
        makeNewPassenger();
        makeNewPassenger();
        //ypedQuery<List<Ticket>> query = entityManager().createNamedQuery(Passenger.FIND_TICKETS_BY_PASSENGERID, List<>.class).setParameter("searchid", 1);
        //List<List<Ticket>> totalFlyerMiles = query.getResultList();
    }


    public void makeNewPassenger(){
        Passenger passenger = new Passenger("test","Tim","De Haes", 10, new Date(), PassengerType.OCCASIONAL, "test", "test","test","test","test","test");
        entityManager().persist(passenger);
    }

}
