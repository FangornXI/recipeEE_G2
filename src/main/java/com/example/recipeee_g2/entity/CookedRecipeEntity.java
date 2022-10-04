package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "cooked_recipe", schema = "recipe")
public class CookedRecipeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    private RecipeEntity recipeByRecipeId;

    public CookedRecipeEntity(Date date, UserEntity userByUserId, RecipeEntity recipeByRecipeId) {
        this.date = date;
        this.userByUserId = userByUserId;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public CookedRecipeEntity(int id, Date date, UserEntity userByUserId, RecipeEntity recipeByRecipeId) {
        this.id = id;
        this.date = date;
        this.userByUserId = userByUserId;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public CookedRecipeEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public RecipeEntity getRecipeByRecipeId() {
        return recipeByRecipeId;
    }

    public void setRecipeByRecipeId(RecipeEntity recipeByRecipeId) {
        this.recipeByRecipeId = recipeByRecipeId;
    }
}
