package com.realdolmen.course.integration;

import com.realdolmen.course.persistence.PassengerBeanRemote;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by SVCAX33 on 11/09/2015.
 */
public class PassengerBeanTest extends RemoteIntegrationTest {

    @Test
    public void testPassengerBeanFindAll() throws NamingException{
        PassengerBeanRemote passengerBean = lookup("ear-module-1.1/ejb-module-1.1/PassengerBean!com.realdolmen.course.persistence.PassengerBeanRemote");
        assertNotNull(passengerBean.findPassengers());
    }
}
