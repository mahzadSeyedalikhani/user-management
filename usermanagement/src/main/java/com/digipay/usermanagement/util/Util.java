package com.digipay.usermanagement.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Util {

    private static final EntityManagerFactory entityMangerFactory;

    static {
        entityMangerFactory = Persistence.createEntityManagerFactory("user");
    }

    public static EntityManagerFactory getEntityMangerFactory() {

        return entityMangerFactory;
    }
}
