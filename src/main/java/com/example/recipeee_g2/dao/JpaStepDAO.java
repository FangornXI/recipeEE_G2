package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.StepEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaStepDAO implements ObjectDAO<StepEntity> {
    @Override
    public List<StepEntity>  findByField(String paramName , String param) {
        List<StepEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            CriteriaQuery<StepEntity> query = builder.createQuery(StepEntity.class);
            Root<StepEntity> i = query.from(StepEntity.class);
            query.select(i);
            query.where(builder.lessThanOrEqualTo(i.get(paramName).as(String.class), param));
            objectList = em.createQuery(query).getResultList();;
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return objectList;
    }
    @Override
    public List<StepEntity> findAll() {
        List<StepEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        try{
            objectList = em.createQuery("select c from StepEntity c", StepEntity.class).getResultList();
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return objectList;
    }

    @Override
    public boolean create(StepEntity object) {
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
    public Optional<StepEntity> findById(int idParam) {
        EntityManager em = EMFManager.getEMF().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            StepEntity object = em.find(StepEntity.class,idParam);
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

        StepEntity object = em.find(StepEntity.class,id);

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
    public boolean edit(StepEntity object) {
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
