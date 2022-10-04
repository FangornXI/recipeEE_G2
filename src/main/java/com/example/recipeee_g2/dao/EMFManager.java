package com.example.recipeee_g2.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class EMFManager {

    private static EntityManagerFactory EMF_SINGLETON = null;

    private EMFManager() {
        // avoid instantiation
    }

    public static EntityManagerFactory getEMF() {
        if (EMF_SINGLETON == null) {
            try {
                EMF_SINGLETON = Persistence.createEntityManagerFactory("PU");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("EntityManager impossible");
            }
        }
        return EMF_SINGLETON;
    }

    public static void closeEMF() {
        try {
            EMF_SINGLETON.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
