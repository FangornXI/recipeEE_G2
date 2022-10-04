package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "user", schema = "recipe", catalog = "")
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
    @OneToMany(mappedBy = "userByUserId")
    private Collection<CookedRecipeEntity> cookedRecipesById;
    @OneToMany(mappedBy = "userByAuthorId")
    private Collection<RecipeEntity> recipesById;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (photoUrl != null ? !photoUrl.equals(that.photoUrl) : that.photoUrl != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (photoUrl != null ? photoUrl.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
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

    public Collection<RecipeEntity> getRecipesById() {
        return recipesById;
    }

    public void setRecipesById(Collection<RecipeEntity> recipesById) {
        this.recipesById = recipesById;
    }
}
