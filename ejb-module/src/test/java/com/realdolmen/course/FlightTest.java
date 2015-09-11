package com.realdolmen.course;

import com.realdolmen.course.domain.Flight;
import com.realdolmen.course.domain.InternationalFlight;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

import java.util.Date;

/**
 * Created by SVCAX33 on 10/09/2015.
 */
public class FlightTest extends DataSetPersistenceTest {

    @Test
    public void flightCanBePersisted () throws Exception{
        Flight f = new InternationalFlight("3", new Date(), new Date(), "Sabena", true, "test");
        entityManager().persist(f);

        assertNotNull((entityManager().find(Flight.class, 1)));
    }

    @Test
    public void flightImplementsPolymorfism () throws Exception{
        Flight f = new InternationalFlight("3", new Date(), new Date(), "Sabena", true, "test");
        entityManager().persist(f);

        // persist, flush: alle transacties doorvoeren, clear: alles detachen uit cache halen, and find beter

        assertNotNull(((InternationalFlight)entityManager().find(Flight.class, 1)).getBlacklisted());
    }
}
