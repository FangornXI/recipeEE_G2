package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.CommentEntity;
import com.example.recipeee_g2.entity.RecipeEntity;
import com.example.recipeee_g2.entity.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/populate")
public class PopulateServlet extends HttpServlet {

    private static List<UserEntity> users = new ArrayList(){{
        UserEntity user1 = new UserEntity("Le boutantrin", "Quentin", "quentin@test.fr", null, "root", null, null, null);
        add(user1);
        UserEntity user2 = new UserEntity("Le philosophe", "Mohamed", "mohamed@test.fr", null, "root", null, null, null);
        add(user2);
        UserEntity user3 = new UserEntity("Le narrateur", "David", "david@test.fr", null, "root", null, null, null);
        add(user3);

    }};

    private static List<RecipeEntity> recipes = new ArrayList(){{
        RecipeEntity recipe1 = new RecipeEntity("tagine", "plat", "blablabla", "https://assets.afcdn.com/recipe/20180827/81947_w640h486c1cx2886cy4330cxb5773cyb8660.webp", "hard", "peu cher", 60, 30, 90, null, null, users.get(1), null, null);
        add(recipe1);
        RecipeEntity recipe2 = new RecipeEntity("colombo", "plat", "blablabla", "https://assets.afcdn.com/recipe/20210216/117987_w640h486c1cx1060cy707cxb2121cyb1414.webp", "hard", "peu cher", 60, 30, 90, null, null, users.get(2), null, null);
        add(recipe2);
        RecipeEntity recipe3 = new RecipeEntity("filet mignon", "plat", "blablabla", "https://assets.afcdn.com/recipe/20171004/72705_w1000h1500c1cx2000cy3000cxb4000cyb6000.webp", "hard", "peu cher", 60, 30, 90, null, null, users.get(0), null, null);
        add(recipe3);


    }};



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        users.forEach(userEntity -> DaoFactory.getUserDAO().create(userEntity));

        recipes.forEach(recipe -> DaoFactory.getRecipeDAO().create(recipe)
        );
    }
}
