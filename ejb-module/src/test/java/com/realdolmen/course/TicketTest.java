package com.realdolmen.course;

import com.realdolmen.course.domain.*;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import org.junit.Test;

import java.util.Date;

/**
 * Created by SVCAX33 on 10/09/2015.
 */
public class TicketTest extends DataSetPersistenceTest{

    @Test
    public void TicketCanBePersisted() throws Exception{
        Ticket t = new Ticket(1700);
        entityManager().persist(t);
        assertNotNull(t.getId());
    }

    @Test
    public void FlightCanBeAssignedToATicket() throws Exception {
        Ticket t = new Ticket(50);
        entityManager().persist(t);
        Flight f = new InternationalFlight("3", new Date(), new Date(), "Sabena", true, "test");
        entityManager().persist(f);
        t.setFlight(f);
        assertNotNull(t.getFlight());
    }

    @Test
    public void ticketCanBeRetrievedFromTheDatabase() throws Exception{
        Ticket ticket = entityManager().find(Ticket.class,1000);
        assertEquals(150, ticket.getPrice(), 0.01);
    }


    @Test(expected = IllegalArgumentException.class)
    public void ticketPriceMustNotBeNegative() throws Exception {
        Ticket t = new Ticket(-1);

    }

    @Test
    public void PassengerCanBeAssignedToATicket() throws Exception{
        Passenger passenger = new Passenger("test","Tim","De Haes", 10, new Date(), PassengerType.OCCASIONAL, "test", "test","test","test","test","test");
        entityManager().persist(passenger);
        Ticket ticket = new Ticket(50);
        entityManager().persist(ticket);
        ticket.setPassenger(passenger);

        assertEquals("De Haes", ticket.getPassenger().getLastName());
    }

}
