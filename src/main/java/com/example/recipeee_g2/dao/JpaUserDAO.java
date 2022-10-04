package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaUserDAO implements ObjectDAO<UserEntity> {
    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();

        try{
            objectList = em.createQuery("select c from UserEntity c", UserEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return objectList;
    }

    @Override
    public boolean create(UserEntity object) {
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
    public Optional<UserEntity> findById(long idParam) {
        EntityManager em = EMFManager.getEMF().createEntityManager();
        try{
            UserEntity object = em.find(UserEntity.class,idParam);
            return Optional.of(object);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {

        EntityManager em = EMFManager.getEMF().createEntityManager();

        UserEntity object = em.find(UserEntity.class,id);

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
    public boolean edit(UserEntity object) {
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