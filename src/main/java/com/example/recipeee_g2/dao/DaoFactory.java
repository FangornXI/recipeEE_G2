package com.example.recipeee_g2.dao;

import com.example.recipeee_g2.entity.*;

public class DaoFactory {

    private DaoFactory() {
    }

    public static ObjectDAO<CommentEntity> getCommentDAO() {
        return new JpaCommentDAO();
    }
    public static ObjectDAO<CookedRecipeEntity> getCookedRecipeDAO() {
        return new JpaCookedRecipeDAO();
    }
    public static ObjectDAO<IngredientEntity> getIngredientDAO() {
        return new JpaIngredientDAO();
    }
    public static ObjectDAO<RecipeEntity> getRecipeDAO() {
        return new JpaRecipeDAO();
    }
    public static ObjectDAO<RecipeIngredientEntity> getRecipeIngredientDAO() {
        return new JpaRecipeIngredientDAO();
    }
    public static ObjectDAO<StepEntity> getStepDAO() {
        return new JpaStepDAO();
    }
    public static ObjectDAO<UserEntity> getUserDAO() {
        return new JpaUserDAO();
    }
}
