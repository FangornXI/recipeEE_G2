package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "recipe", schema = "recipe", catalog = "")
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
    @Basic
    @Column(name = "author_id")
    private Integer authorId;
    @OneToMany(mappedBy = "recipeByRecipeId")
    private Collection<CommentEntity> commentsById;
    @OneToMany(mappedBy = "recipeByRecipeId")
    private Collection<CookedRecipeEntity> cookedRecipesById;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private UserEntity userByAuthorId;
    @OneToMany(mappedBy = "recipeByRecipeId")
    private Collection<RecipeIngredientEntity> recipeIngredientsById;
    @OneToMany(mappedBy = "recipeByRecipeId")
    private Collection<StepEntity> stepsById;

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

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeEntity that = (RecipeEntity) o;

        if (id != that.id) return false;
        if (prepTime != that.prepTime) return false;
        if (restTime != that.restTime) return false;
        if (cookTime != that.cookTime) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (photoUrl != null ? !photoUrl.equals(that.photoUrl) : that.photoUrl != null) return false;
        if (dificulty != null ? !dificulty.equals(that.dificulty) : that.dificulty != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (dificulty != null ? dificulty.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + prepTime;
        result = 31 * result + restTime;
        result = 31 * result + cookTime;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        return result;
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
