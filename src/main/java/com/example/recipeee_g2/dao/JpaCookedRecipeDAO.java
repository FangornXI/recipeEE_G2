package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.CookedRecipeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaCookedRecipeDAO implements ObjectDAO<CookedRecipeEntity> {
    @Override
    public List<CookedRecipeEntity> findAll() {
        List<CookedRecipeEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();

        try{
            objectList = em.createQuery("select c from CookedRecipeEntity c", CookedRecipeEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return objectList;
    }

    @Override
    public boolean create(CookedRecipeEntity object) {
        EntityManager em = EMFManager.getEMF().createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(object);
            et.commit();
            return true;
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
        }finally {
            em.close();
        }
        return false;
    }

    @Override
    public Optional<CookedRecipeEntity> findById(int idParam) {
        EntityManager em = EMFManager.getEMF().createEntityManager();
        try{
            CookedRecipeEntity object = em.find(CookedRecipeEntity.class,idParam);
            return Optional.of(object);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(int id) {

        EntityManager em = EMFManager.getEMF().createEntityManager();

        CookedRecipeEntity object = em.find(CookedRecipeEntity.class,id);

        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.remove(object);
            et.commit();
            return true;
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
        }finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean edit(CookedRecipeEntity object) {
        EntityManager em = EMFManager.getEMF().createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        try{
            em.merge(object);
            et.commit();
            return true;
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
        }finally {
            em.close();
        }
        return false;
    }
}
