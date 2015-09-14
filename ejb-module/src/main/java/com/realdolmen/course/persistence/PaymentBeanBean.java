package com.realdolmen.course.persistence;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.concurrent.Future;

/**
 * Created by SVCAX33 on 14/09/2015.
 */
@Stateless
@Asynchronous
@Remote
public class PaymentBeanBean implements PaymentBeanRemote{

    @Resource
    SessionContext ctx;

    public PaymentBeanBean() {
    }

    public Future<String> payByCreditcard(){

        if(ctx.wasCancelCalled()){
            return new AsyncResult<String>("Done");
        }
        else{
            return new AsyncResult<String>("Busy");
        }

    }
}
