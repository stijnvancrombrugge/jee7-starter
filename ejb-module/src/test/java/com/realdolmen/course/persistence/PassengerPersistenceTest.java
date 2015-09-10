package com.realdolmen.course.persistence;

import com.realdolmen.course.Passenger;
import com.realdolmen.course.PassengerType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.time.Instant;
import java.util.Date;

/**
 * Created by SVCAX33 on 9/09/2015.
 */
public class PassengerPersistenceTest extends DataSetPersistenceTest {

    @Rule
    public ExpectedException expector = ExpectedException.none();

    @Test
    public void PassengerCanBePersisted() throws Exception {
        Passenger passenger = new Passenger("test","Tim","De Haes", 10, new Date(), PassengerType.OCCASIONAL, "test", "test","test","test","test","test");
        entityManager().persist(passenger);
        assertNotNull(passenger.getId());
    }

    @Test(expected = PersistenceException.class)
    public void PassengerCanNotBePersistedWithoutFirstName() throws Exception {
        Passenger passenger = new Passenger(null, "test", "test", 4, new Date(), PassengerType.OCCASIONAL,"test","test","test","test","test", "test");
        entityManager().persist(passenger);
    }

    @Test
    public void PassengerCanBeRetrievedById() throws Exception{
        assertEquals("Stijn", entityManager().find(Passenger.class, 10).getFirstName());
    }


    @Test
    public void passengerCreateAndRetrieve() throws Exception{
        Passenger passenger = new Passenger("test","Tim","De Haes", 10, new Date(), PassengerType.OCCASIONAL, "test", "test","test","test","test","test");
        entityManager().persist(passenger);
        entityManager().flush();
        entityManager().clear();
        entityManager().getReference(Passenger.class, 1);
    }

    @Test
    public void passengerUpdateAndRefresh() throws Exception{
        Passenger passenger = new Passenger("test","Tim","De Haes", 10, new Date(), PassengerType.OCCASIONAL, "test", "test","test","test","test","test");
        entityManager().persist(passenger);
        passenger.setFirstName("Stijn");
        entityManager().refresh(passenger);
        assertEquals(passenger.getFirstName(), "Tim");
    }

    @Test(expected = EntityNotFoundException.class)
    public void passengerRemove() throws Exception{
        entityManager().remove(entityManager().getReference(Passenger.class, 1));
        entityManager().getReference(Passenger.class, 1);
    }

}
