package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.RecipeIngredientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaRecipeIngredientDAO implements ObjectDAO<RecipeIngredientEntity> {
    @Override
    public List<RecipeIngredientEntity> findAll() {
        List<RecipeIngredientEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();

        try{
            objectList = em.createQuery("select c from RecipeIngredientEntity c", RecipeIngredientEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return objectList;
    }

    @Override
    public boolean create(RecipeIngredientEntity object) {
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
    public Optional<RecipeIngredientEntity> findById(int idParam) {
        EntityManager em = EMFManager.getEMF().createEntityManager();
        try{
            RecipeIngredientEntity object = em.find(RecipeIngredientEntity.class,idParam);
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

        RecipeIngredientEntity object = em.find(RecipeIngredientEntity.class,id);

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
    public boolean edit(RecipeIngredientEntity object) {
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
