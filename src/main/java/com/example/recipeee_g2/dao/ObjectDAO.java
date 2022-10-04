package com.example.recipeee_g2.dao;

import java.util.List;
import java.util.Optional;

public interface ObjectDAO<T> {

    List<T> findAll();

    List<T> findByCountry(long idParam);

    boolean create(T object);

    Optional<T> findById(long idParam);

    boolean delete(long id);

    boolean edit(T object);
}
