package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "user", schema = "recipe")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "photo_url")
    private String photoUrl;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<CommentEntity> commentsById;
    @OneToMany(mappedBy = "userByUserId", fetch = FetchType.EAGER)
    private Collection<CookedRecipeEntity> cookedRecipesById;
    @OneToMany(mappedBy = "userByAuthorId")
    private Collection<RecipeEntity> recipesById;


    public UserEntity(int id, String lastname, String firstname, String email, String photoUrl, String password, Collection<CommentEntity> commentsById, Collection<CookedRecipeEntity> cookedRecipesById, Collection<RecipeEntity> recipesById) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.photoUrl = photoUrl;
        this.password = password;
        this.commentsById = commentsById;
        this.cookedRecipesById = cookedRecipesById;
        this.recipesById = recipesById;
    }

    public UserEntity(String lastname, String firstname, String email, String photoUrl, String password, Collection<CommentEntity> commentsById, Collection<CookedRecipeEntity> cookedRecipesById, Collection<RecipeEntity> recipesById) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.photoUrl = photoUrl;
        this.password = password;
        this.commentsById = commentsById;
        this.cookedRecipesById = cookedRecipesById;
        this.recipesById = recipesById;
    }

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Collection<RecipeEntity> getRecipesById() {
        return recipesById;
    }

    public void setRecipesById(Collection<RecipeEntity> recipesById) {
        this.recipesById = recipesById;
    }
}
