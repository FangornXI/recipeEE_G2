package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_ingredient", schema = "recipe")
public class RecipeIngredientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "quantity")
    private double quantity;
    @Basic
    @Column(name = "unit")
    private String unit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ing_id", referencedColumnName = "id", nullable = false)
    private IngredientEntity ingredientByIngId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    private RecipeEntity recipeByRecipeId;

    public RecipeIngredientEntity(int id, double quantity, String unit, IngredientEntity ingredientByIngId, RecipeEntity recipeByRecipeId) {
        this.id = id;
        this.quantity = quantity;
        this.unit = unit;
        this.ingredientByIngId = ingredientByIngId;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public RecipeIngredientEntity(double quantity, String unit, IngredientEntity ingredientByIngId, RecipeEntity recipeByRecipeId) {
        this.quantity = quantity;
        this.unit = unit;
        this.ingredientByIngId = ingredientByIngId;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public RecipeIngredientEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public IngredientEntity getIngredientByIngId() {
        return ingredientByIngId;
    }

    public void setIngredientByIngId(IngredientEntity ingredientByIngId) {
        this.ingredientByIngId = ingredientByIngId;
    }

    public RecipeEntity getRecipeByRecipeId() {
        return recipeByRecipeId;
    }

    public void setRecipeByRecipeId(RecipeEntity recipeByRecipeId) {
        this.recipeByRecipeId = recipeByRecipeId;
    }
}
