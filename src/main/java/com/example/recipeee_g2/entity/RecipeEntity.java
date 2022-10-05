package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "recipe", schema = "recipe")
public class RecipeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "photo_url")
    private String photoUrl;
    @Basic
    @Column(name = "dificulty")
    private String dificulty;
    @Basic
    @Column(name = "price")
    private String price;
    @Basic
    @Column(name = "prep_time")
    private int prepTime;
    @Basic
    @Column(name = "rest_time")
    private int restTime;
    @Basic
    @Column(name = "cook_time")
    private int cookTime;
    @OneToMany(mappedBy = "recipeByRecipeId", fetch = FetchType.EAGER)
    private Collection<CommentEntity> commentsById;
    @OneToMany(mappedBy = "recipeByRecipeId", fetch = FetchType.EAGER)
    private Collection<CookedRecipeEntity> cookedRecipesById;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity userByAuthorId;
    @OneToMany(mappedBy = "recipeByRecipeId", fetch = FetchType.EAGER)
    private Collection<RecipeIngredientEntity> recipeIngredientsById;
    @OneToMany(mappedBy = "recipeByRecipeId", fetch = FetchType.EAGER)
    private Collection<StepEntity> stepsById;

    public RecipeEntity(int id, String name, String type, String description, String photoUrl, String dificulty, String price, int prepTime, int restTime, int cookTime, Collection<CommentEntity> commentsById, Collection<CookedRecipeEntity> cookedRecipesById, UserEntity userByAuthorId, Collection<RecipeIngredientEntity> recipeIngredientsById, Collection<StepEntity> stepsById) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.photoUrl = photoUrl;
        this.dificulty = dificulty;
        this.price = price;
        this.prepTime = prepTime;
        this.restTime = restTime;
        this.cookTime = cookTime;
        this.commentsById = commentsById;
        this.cookedRecipesById = cookedRecipesById;
        this.userByAuthorId = userByAuthorId;
        this.recipeIngredientsById = recipeIngredientsById;
        this.stepsById = stepsById;
    }

    public RecipeEntity(String name, String type, String description, String photoUrl, String dificulty, String price, int prepTime, int restTime, int cookTime, Collection<CommentEntity> commentsById, Collection<CookedRecipeEntity> cookedRecipesById, UserEntity userByAuthorId, Collection<RecipeIngredientEntity> recipeIngredientsById, Collection<StepEntity> stepsById) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.photoUrl = photoUrl;
        this.dificulty = dificulty;
        this.price = price;
        this.prepTime = prepTime;
        this.restTime = restTime;
        this.cookTime = cookTime;
        this.commentsById = commentsById;
        this.cookedRecipesById = cookedRecipesById;
        this.userByAuthorId = userByAuthorId;
        this.recipeIngredientsById = recipeIngredientsById;
        this.stepsById = stepsById;
    }

    public RecipeEntity() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDificulty() {
        return dificulty;
    }

    public void setDificulty(String dificulty) {
        this.dificulty = dificulty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public Collection<CommentEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentEntity> commentsById) {
        this.commentsById = commentsById;
    }

    public Collection<CookedRecipeEntity> getCookedRecipesById() {
        return cookedRecipesById;
    }

    public void setCookedRecipesById(Collection<CookedRecipeEntity> cookedRecipesById) {
        this.cookedRecipesById = cookedRecipesById;
    }

    public UserEntity getUserByAuthorId() {
        return userByAuthorId;
    }

    public void setUserByAuthorId(UserEntity userByAuthorId) {
        this.userByAuthorId = userByAuthorId;
    }

    public Collection<RecipeIngredientEntity> getRecipeIngredientsById() {
        return recipeIngredientsById;
    }

    public void setRecipeIngredientsById(Collection<RecipeIngredientEntity> recipeIngredientsById) {
        this.recipeIngredientsById = recipeIngredientsById;
    }

    public Collection<StepEntity> getStepsById() {
        return stepsById;
    }

    public void setStepsById(Collection<StepEntity> stepsById) {
        this.stepsById = stepsById;
    }
}
