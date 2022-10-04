package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comment", schema = "recipe")
public class CommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "text_comment")
    private String textComment;
    @Basic
    @Column(name = "rating")
    private Integer rating;
    @Basic
    @Column(name = "note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    private RecipeEntity recipeByRecipeId;

    public CommentEntity(int id, String textComment, Integer rating, String note, UserEntity userByUserId, RecipeEntity recipeByRecipeId) {
        this.id = id;
        this.textComment = textComment;
        this.rating = rating;
        this.note = note;
        this.userByUserId = userByUserId;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public CommentEntity(String textComment, Integer rating, String note, UserEntity userByUserId, RecipeEntity recipeByRecipeId) {
        this.textComment = textComment;
        this.rating = rating;
        this.note = note;
        this.userByUserId = userByUserId;
        this.recipeByRecipeId = recipeByRecipeId;
    }

    public CommentEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public RecipeEntity getRecipeByRecipeId() {
        return recipeByRecipeId;
    }

    public void setRecipeByRecipeId(RecipeEntity recipeByRecipeId) {
        this.recipeByRecipeId = recipeByRecipeId;
    }
}
