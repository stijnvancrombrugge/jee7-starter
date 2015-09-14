package com.realdolmen.course.persistence;


import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;


/**
 * Created by SVCAX33 on 14/09/2015.
 */
@Stateless
public class ClockBean{
    private int count = 0;


    public ClockBean() {

    }

    @Schedule(second="0/10", minute = "*", hour = "*", persistent = false)
    public void invoke(Timer timer){
        System.out.println("**********************");
        if(count++ == 10){
            timer.cancel();
        }
    }

}
