package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.PassengerType;

import javax.ejb.Remote;
import java.util.Date;

/**
 * Created by SVCAX33 on 14/09/2015.
 */

@Remote
public interface PassengerStatefulBeanRemote{

    void addPassenger(String ssn, String firstName, String lastName, Integer frequentFlyerMiles, Date dateOfBirth, PassengerType type, String street1, String street2, String city, String state, String zipcode, String country);
    void addAddress(Address address);
    void addCreditCard(CreditCard creditCard);
    void addTicket(int price);
    void checkout();
}
