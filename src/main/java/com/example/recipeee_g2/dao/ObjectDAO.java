package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface ObjectDAO<T> {

    List<T> findAll();

    boolean create(T object);

    Optional<T> findById(int idParam);

    boolean delete(int id);

    boolean edit(T object);

    List<T> findByField(String paramName , String param);
}
