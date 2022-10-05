package com.example.recipeee_g2.servlet;


import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.RecipeEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/homepage")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<RecipeEntity> recipes = DaoFactory.getRecipeDAO().findAll();

            recipes.forEach(recipeEntity -> System.out.println(recipeEntity.getName()));
            req.setAttribute("recipes", recipes);
        }catch (Exception e){
            e.printStackTrace();
        }

        req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
