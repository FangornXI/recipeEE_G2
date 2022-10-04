package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "ingredient", schema = "recipe", catalog = "")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientEntity that = (IngredientEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (photoUrl != null ? !photoUrl.equals(that.photoUrl) : that.photoUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        return result;
    }

    public Collection<RecipeIngredientEntity> getRecipeIngredientsById() {
        return recipeIngredientsById;
    }

    public void setRecipeIngredientsById(Collection<RecipeIngredientEntity> recipeIngredientsById) {
        this.recipeIngredientsById = recipeIngredientsById;
    }
}
