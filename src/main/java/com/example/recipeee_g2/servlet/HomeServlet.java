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
        List<RecipeEntity> recipes = DaoFactory.getRecipeDAO().findAll();
        req.setAttribute("recipes", recipes);
        req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, resp);
    }
}
