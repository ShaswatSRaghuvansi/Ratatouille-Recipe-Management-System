package com.masaischool.Ratatouille.RMS.Utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMUtils {
    // Static EntityManagerFactory to manage the creation of EntityManager instances.
    static EntityManagerFactory emf;

    // Static block that runs when the class is loaded to initialize the EntityManagerFactory.
    static {
        // Create an EntityManagerFactory based on the "dbconnect" persistence unit defined in persistence.xml.
        emf = Persistence.createEntityManagerFactory("dbconnect");
    }

    // Public method to obtain an EntityManager for performing database operations.
    public static EntityManager getEntityManager() {
        // Create and return an EntityManager instance using the initialized EntityManagerFactory.
        return emf.createEntityManager();
    }
}
