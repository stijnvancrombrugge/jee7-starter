package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.CreditCardType;
import com.realdolmen.course.domain.PassengerType;
import com.realdolmen.course.persistence.PassengerStatefulBean;
import com.realdolmen.course.persistence.PassengerStatefulBeanRemote;
import org.junit.Test;

import javax.naming.NamingException;
import java.time.Instant;
import java.util.Date;

/**
 * Created by SVCAX33 on 14/09/2015.
 */
public class PassengerStatefulBeanTest  extends RemoteIntegrationTest {


    @Test
    public void testStatefulBean() throws NamingException{
        PassengerStatefulBeanRemote passengerStatefulBean = lookup("ear-module-1.1/ejb-module-1.1/PassengerStatefulBean!com.realdolmen.course.persistence.PassengerStatefulBeanRemote");
        passengerStatefulBean.addPassenger("testssn", "Stijn", "vc", 10, Date.from(Instant.now()), PassengerType.OCCASIONAL, "he", "ac", "sdb", "eu", "9630", "be");
        passengerStatefulBean.addAddress(new Address("he", "ac", "sdb", "eu", "9630", "be"));
        passengerStatefulBean.addCreditCard(new CreditCard("test", "test", 5, CreditCardType.MASTER));
        passengerStatefulBean.checkout();

    }
}
