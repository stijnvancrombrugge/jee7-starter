package com.realdolmen.course;

import javax.persistence.MappedSuperclass;

/**
 * Created by SVCAX33 on 10/09/2015.
 */

@MappedSuperclass
public abstract class AbstractEntity {

    private int version;
    private String userModified;
}
