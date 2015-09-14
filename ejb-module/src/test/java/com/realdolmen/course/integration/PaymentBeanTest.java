package com.realdolmen.course.integration;

import com.realdolmen.course.persistence.PaymentBeanBean;
import com.realdolmen.course.persistence.PaymentBeanRemote;
import org.junit.Test;

import javax.naming.NamingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by SVCAX33 on 14/09/2015.
 */


public class PaymentBeanTest extends RemoteIntegrationTest{


    @Test
    public void payByCreditCardTest() throws NamingException, ExecutionException, InterruptedException {

        PaymentBeanRemote paymentBeanBean = lookup("ear-module-1.1/ejb-module-1.1/PaymentBeanBean!com.realdolmen.course.persistence.PaymentBeanRemote");
        Future<String> message = paymentBeanBean.payByCreditcard();
        String endMessage = message.get();
        assertEquals("Busy", endMessage);
    }
}
