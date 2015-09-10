package com.realdolmen.course;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by SVCAX33 on 10/09/2015.
 */

@Stateless
@LocalBean
public class PassengerRepository {

    @PersistenceContext
    EntityManager entityManager;



}
