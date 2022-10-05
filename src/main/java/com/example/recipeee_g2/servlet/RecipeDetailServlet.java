package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.RecipeEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/recipe")
public class RecipeDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Optional<RecipeEntity> foundRecipe = DaoFactory.getRecipeDAO().findById(id);

        if (foundRecipe.isPresent()){

            req.setAttribute("recipe",foundRecipe.get());
            req.setAttribute("recipeIngredients",foundRecipe.get().getRecipeIngredientsById());
            req.setAttribute("comments",foundRecipe.get().getCommentsById());
            req.setAttribute("steps",foundRecipe.get().getStepsById());
            //req.setAttribute("cookedRecipes",foundRecipe.get().getCookedRecipesById());

            req.getRequestDispatcher("/WEB-INF/recipeDetail.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/homepage");
        }

    }
}
