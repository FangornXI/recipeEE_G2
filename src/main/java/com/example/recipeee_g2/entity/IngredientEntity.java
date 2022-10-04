package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "ingredient", schema = "recipe")
public class IngredientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "photo_url")
    private String photoUrl;
    @OneToMany(mappedBy = "ingredientByIngId")
    private Collection<RecipeIngredientEntity> recipeIngredientsById;

    public IngredientEntity(int id, String name, String photoUrl, Collection<RecipeIngredientEntity> recipeIngredientsById) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.recipeIngredientsById = recipeIngredientsById;
    }

    public IngredientEntity(String name, String photoUrl, Collection<RecipeIngredientEntity> recipeIngredientsById) {
        this.name = name;
        this.photoUrl = photoUrl;
        this.recipeIngredientsById = recipeIngredientsById;
    }

    public IngredientEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Collection<RecipeIngredientEntity> getRecipeIngredientsById() {
        return recipeIngredientsById;
    }

    public void setRecipeIngredientsById(Collection<RecipeIngredientEntity> recipeIngredientsById) {
        this.recipeIngredientsById = recipeIngredientsById;
    }
}
