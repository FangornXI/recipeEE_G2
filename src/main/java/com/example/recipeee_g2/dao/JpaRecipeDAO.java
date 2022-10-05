package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.RecipeEntity;
import com.example.recipeee_g2.entity.RecipeIngredientEntity;
import com.example.recipeee_g2.entity.StepEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaRecipeDAO implements ObjectDAO<RecipeEntity> {
    @Override
    public List<RecipeEntity>  findByField(String paramName , String param) {
        List<RecipeEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            CriteriaQuery<RecipeEntity> query = builder.createQuery(RecipeEntity.class);
            Root<RecipeEntity> i = query.from(RecipeEntity.class);
            query.select(i);
            query.where(builder.lessThanOrEqualTo(i.get(paramName).as(String.class), param));
            objectList = em.createQuery(query).getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return objectList;
    }
    @Override
    public List<RecipeEntity> findAll() {
        List<RecipeEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        try{
            objectList = em.createQuery("select c from RecipeEntity c", RecipeEntity.class).getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return objectList;
    }

    @Override
    public boolean create(RecipeEntity object) {
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
    public Optional<RecipeEntity> findById(int idParam) {
        EntityManager em = EMFManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            RecipeEntity object = em.find(RecipeEntity.class,idParam);
            et.commit();
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

        RecipeEntity object = em.find(RecipeEntity.class,id);

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
    public boolean edit(RecipeEntity object) {
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
