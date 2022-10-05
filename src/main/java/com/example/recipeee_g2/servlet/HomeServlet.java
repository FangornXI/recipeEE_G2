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

@WebServlet("/homepage")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String dificulty = req.getParameter("dificulty");
        String price = req.getParameter("price");
        String histo = req.getParameter("histo");
        List<RecipeEntity> recipes = new ArrayList<>();
        try {
            if (histo!=null){
                int iduser = Integer.parseInt(req.getSession().getAttribute("user").toString());
                UserEntity user = DaoFactory.getUserDAO().findById(iduser).get();
                Collection<CookedRecipeEntity> cookedRecipes = user.getCookedRecipesById();
                for (CookedRecipeEntity c : cookedRecipes){
                    recipes.add(c.getRecipeByRecipeId());
                }
                Set<RecipeEntity> setWithUniqueValues = new HashSet<>(recipes);
                recipes = new ArrayList<>(setWithUniqueValues);
            }else{
                recipes = DaoFactory.getRecipeDAO().findAll();
            }

            if (type!=null){
                recipes.removeIf(e->!e.getType().equals(type));
            }
            if (dificulty!=null){
                recipes.removeIf(e->!e.getDificulty().equals(dificulty));
            }
            if (price!=null){
                recipes.removeIf(e->!e.getPrice().equals(price));
            }
            if (name!=null){
                recipes.removeIf(e->!e.getName().contains(name));
            }
            recipes.forEach(recipeEntity -> System.out.println(recipeEntity.getName()));
            req.setAttribute("recipes", recipes);
            req.setAttribute("histo", histo);
            req.setAttribute("name", name);
            req.setAttribute("type", type);
            req.setAttribute("dificulty", dificulty);
            req.setAttribute("price", price);
        }catch (Exception e){
            e.printStackTrace();
        }

        req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String dificulty = req.getParameter("dificulty");
        String price = req.getParameter("price");
        String histo = req.getParameter("histo");
        String param = "?";
        if (histo!=""){
            param = param + "histo=true";
        }
        if (type!=""){
            if (param != "?") { param =param + "&";}
            param = param + "type=" + type;
        }
        if (dificulty!=""){
            if (param != "?") { param =param + "&";}
            param = param + "dificulty=" + dificulty;
        }
        if (price!=""){
            if (param != "?") { param =param + "&";}
            param = param + "price=" + price;
        }
        if (name!=""){
            if (param != "?") { param =param + "&";}
            param = param + "name=" + name;
        }

        if (param == "?") {
            resp.sendRedirect(req.getContextPath() + "/homepage");
        }else {
            resp.sendRedirect(req.getContextPath() + "/homepage" + param);
        }
    }
}
