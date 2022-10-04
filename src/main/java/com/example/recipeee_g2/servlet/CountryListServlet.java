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

@WebServlet({"/country"})
public class CountryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // Requete a la base de données, traitements, calculs..
        List<RecipeEntity> countryList = DaoFactory.getRecipeDAO().findAll();
        // Insertion des données dans la requête
        // Rends l'information disponible dans la vue JSP
        request.setAttribute("countries", countryList);
    }
}
