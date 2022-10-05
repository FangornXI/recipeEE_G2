package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
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

    private static List<IngredientEntity> ingredients = new ArrayList(){{
        IngredientEntity ing1 = new IngredientEntity("sel", "https://assets.afcdn.com/story/20190408/1341791_w944h530c1cx2880cy1920.webp", null);
        add(ing1);
        IngredientEntity ing2 = new IngredientEntity("poivre", null, null);
        add(ing2);
        IngredientEntity ing3 = new IngredientEntity("coriandre", null, null);
        add(ing3);
    }};

    private static List<RecipeIngredientEntity> ris = new ArrayList(){{
        RecipeIngredientEntity ri1 = new RecipeIngredientEntity(10.0, "gr", ingredients.get(0), recipes.get(0));
        add(ri1);
        RecipeIngredientEntity ri2 = new RecipeIngredientEntity(20.0, "gr", ingredients.get(1), recipes.get(1));
        add(ri2);
        RecipeIngredientEntity ri3 = new RecipeIngredientEntity(30.0, "gr", ingredients.get(2), recipes.get(2));
        add(ri3);
    }};





    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        users.forEach(userEntity -> {
            try
            {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // Add password bytes to digest
                md.update(userEntity.getPassword().getBytes());

                // Get the hash's bytes
                byte[] bytes = md.digest();

                // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }

                // Get complete hashed password in hex format
                userEntity.setPassword(sb.toString());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        });
        users.forEach(userEntity -> DaoFactory.getUserDAO().create(userEntity));

        recipes.forEach(recipe -> DaoFactory.getRecipeDAO().create(recipe));

        ingredients.forEach(i-> DaoFactory.getIngredientDAO().create(i));

        ris.forEach(ri -> DaoFactory.getRecipeIngredientDAO().create(ri));
    }
}
