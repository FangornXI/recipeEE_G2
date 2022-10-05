package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.CookedRecipeEntity;
import com.example.recipeee_g2.entity.RecipeEntity;
import com.example.recipeee_g2.entity.UserEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@WebServlet("/reciperand")
public class RandomRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date dateJ  = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateJ);
        c.add(Calendar.DATE, -6);
        dateJ =c.getTime();
        List<RecipeEntity> recipes = DaoFactory.getRecipeDAO().findAll();
        int iduser = Integer.parseInt(req.getSession().getAttribute("user").toString());
        UserEntity user = DaoFactory.getUserDAO().findById(iduser).get();
        Collection<CookedRecipeEntity> cookedRecipes = user.getCookedRecipesById();
        for (CookedRecipeEntity cr : cookedRecipes){
            if (cr.getDate().after(dateJ)){
                recipes = recipes.stream().filter(recipe -> recipe.getId() != cr.getRecipeByRecipeId().getId()).collect(Collectors.toList());
            }
        }
        Random random = new Random();
        int nb;
        nb = random.nextInt(recipes.size());

        resp.sendRedirect(req.getContextPath() + "/recipe?id=" + recipes.get(nb).getId());
    }
}
