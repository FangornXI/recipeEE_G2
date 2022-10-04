package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "step", schema = "recipe", catalog = "")
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
    @Basic
    @Column(name = "recipe_id")
    private int recipeId;
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    private RecipeEntity recipeByRecipeId;

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

        StepEntity that = (StepEntity) o;

        if (id != that.id) return false;
        if (stepNumber != that.stepNumber) return false;
        if (recipeId != that.recipeId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + stepNumber;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + recipeId;
        return result;
    }

    public RecipeEntity getRecipeByRecipeId() {
        return recipeByRecipeId;
    }

    public void setRecipeByRecipeId(RecipeEntity recipeByRecipeId) {
        this.recipeByRecipeId = recipeByRecipeId;
    }
}
