package com.realdolmen.course.persistence;

import javax.ejb.Remote;
import java.util.concurrent.Future;

/**
 * Created by SVCAX33 on 14/09/2015.
 */

@Remote
public interface PaymentBeanRemote {

    Future<String> payByCreditcard();
}
