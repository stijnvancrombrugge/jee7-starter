package com.realdolmen.course.persistence;

import com.realdolmen.course.Passenger;
import com.realdolmen.course.PassengerId;
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
    public void PassengerCanBePersistedwithCompositeId() throws Exception {
        Passenger passenger = new Passenger("test","Tim","De Haes",10);
        entityManager().persist(passenger);
        assertNotNull(passenger.getPassengerId());
    }

    /*
    @Test(expected = PersistenceException.class)
    public void PassengerCanNotBePersistedWithoutFirstName() throws Exception {
        Passenger passenger = new Passenger(null, "test", "test", 4);
        entityManager().persist(passenger);
    }


    @Test
    public void PassengerCanBeRetrievedById() throws Exception{
        assertEquals("Stijn", entityManager().find(Passenger.class, 10).getFirstName());
    }
*/


    @Test
    public void PassengerCanBeRetrievedByCompositeId() throws Exception {
        Passenger passenger = new Passenger("test","Tim","Van Crombrugge",10);
        entityManager().persist(passenger);
        PassengerId pId = new PassengerId("test", "Van Crombrugge");
        assertEquals("Tim", entityManager().find(Passenger.class,pId).getFirstName());
    }


    @Test
    public void PassengerIdEqualsMethod() throws Exception{
        Passenger passenger = new Passenger("testEquals","Tim","Van Crombrugge",10);
        entityManager().persist(passenger);
        PassengerId pId = new PassengerId("testEquals", "Van Crombrugge");
        assertTrue(pId.equals(passenger.getPassengerId()));
    }

}
