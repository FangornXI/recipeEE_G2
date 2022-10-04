package com.example.recipeee_g2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comment", schema = "recipe", catalog = "")
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
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "recipe_id")
    private int recipeId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity userByUserId;
    @ManyToOne
    @JoinColumn(name = "recipe_id", referencedColumnName = "id", nullable = false)
    private RecipeEntity recipeByRecipeId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (recipeId != that.recipeId) return false;
        if (textComment != null ? !textComment.equals(that.textComment) : that.textComment != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (textComment != null ? textComment.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + recipeId;
        return result;
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
