package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.CommentEntity;
import com.example.recipeee_g2.entity.IngredientEntity;
import com.example.recipeee_g2.entity.StepEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaCommentDAO implements ObjectDAO<CommentEntity> {
    @Override
    public List<CommentEntity>  findByField(String paramName , String param) {
        List<CommentEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        try{
            CriteriaQuery<CommentEntity> query = builder.createQuery(CommentEntity.class);
            Root<CommentEntity> i = query.from(CommentEntity.class);
            query.select(i);
            query.where(builder.lessThanOrEqualTo(i.get(paramName).as(String.class), param));
            objectList = em.createQuery(query).getResultList();;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return objectList;
    }
    @Override
    public List<CommentEntity> findAll() {
        List<CommentEntity> objectList = new ArrayList<>();

        EntityManager em = EMFManager.getEMF().createEntityManager();

        try{
            objectList = em.createQuery("select c from CommentEntity c", CommentEntity.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }

        return objectList;
    }

    @Override
    public boolean create(CommentEntity object) {
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
    public Optional<CommentEntity> findById(int idParam) {
        EntityManager em = EMFManager.getEMF().createEntityManager();
        try{
            CommentEntity object = em.find(CommentEntity.class,idParam);
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

        CommentEntity object = em.find(CommentEntity.class,id);

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
    public boolean edit(CommentEntity object) {
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
