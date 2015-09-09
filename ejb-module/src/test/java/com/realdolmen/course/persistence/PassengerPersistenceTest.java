package com.realdolmen.course.persistence;

import com.realdolmen.course.Passenger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * Created by SVCAX33 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void PassengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger("test","Tim","De Haes",10);
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test(expected = PersistenceException.class)
    public void PassengerCanNotBePersistedWithoutFirstName() throws Exception {
        Passenger passenger = new Passenger(null, "test", "test", 4);
        entityManager().persist(passenger);
    }

    @Test
    public void PassengerCanBeRetrievedById() throws Exception{
        assertEquals("Stijn", entityManager().find(Passenger.class, 10).getFirstName());
    }


}
