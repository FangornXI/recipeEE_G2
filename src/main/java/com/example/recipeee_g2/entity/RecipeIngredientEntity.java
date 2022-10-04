package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_ingredient", schema = "recipe", catalog = "")
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
    @Basic
    @Column(name = "ing_id")
    private int ingId;
    @Basic
    @Column(name = "recipe_id")
    private int recipeId;
    @ManyToOne
    @JoinColumn(name = "ing_id", referencedColumnName = "id", nullable = false)
    private IngredientEntity ingredientByIngId;
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    private RecipeEntity recipeByRecipeId;

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

    public int getIngId() {
        return ingId;
    }

    public void setIngId(int ingId) {
        this.ingId = ingId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeIngredientEntity that = (RecipeIngredientEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.quantity, quantity) != 0) return false;
        if (ingId != that.ingId) return false;
        if (recipeId != that.recipeId) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + ingId;
        result = 31 * result + recipeId;
        return result;
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
