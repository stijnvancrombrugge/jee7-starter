package com.realdolmen.course.integration;

import com.realdolmen.course.persistence.PassengerStatelessBeanRemote;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * Created by SVCAX33 on 11/09/2015.
 */
public class PassengerStatelessBeanTest extends RemoteIntegrationTest {

    @Test
    public void testPassengerBeanFindAll() throws NamingException{
        PassengerStatelessBeanRemote passengerBean = lookup("ear-module-1.1/ejb-module-1.1/PassengerStatelessBean!com.realdolmen.course.persistence.PassengerStatelessBeanRemote");
        assertNotNull(passengerBean.findPassengers());
    }
}
