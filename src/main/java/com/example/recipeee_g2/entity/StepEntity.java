package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "step", schema = "recipe")
public class StepEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "step_number")
    private int stepNumber;
    @Basic
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    private RecipeEntity recipeByRecipeId;

    public StepEntity(int id, int stepNumber, String text, RecipeEntity recipeByRecipeId) {
        this.id = id;
        this.stepNumber = stepNumber;
        this.text = text;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public StepEntity(int stepNumber, String text, RecipeEntity recipeByRecipeId) {
        this.stepNumber = stepNumber;
        this.text = text;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public StepEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RecipeEntity getRecipeByRecipeId() {
        return recipeByRecipeId;
    }

    public void setRecipeByRecipeId(RecipeEntity recipeByRecipeId) {
        this.recipeByRecipeId = recipeByRecipeId;
    }
}
