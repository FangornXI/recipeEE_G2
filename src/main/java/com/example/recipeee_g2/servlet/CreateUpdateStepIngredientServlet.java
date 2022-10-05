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
import java.util.List;
import java.util.Optional;

@WebServlet({"/StepIngredient/Update"})
public class CreateUpdateStepIngredientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Optional<RecipeEntity> foundRecipe = DaoFactory.getRecipeDAO().findById(id);

        if (foundRecipe.isPresent()){

            req.setAttribute("recipe",foundRecipe.get());
            req.setAttribute("recipeIngredients",foundRecipe.get().getRecipeIngredientsById());
            req.setAttribute("steps",foundRecipe.get().getStepsById());
            req.setAttribute("stepsNumber",foundRecipe.get().getStepsById().size());

            req.getRequestDispatcher("/WEB-INF/createUpdateStepIngredient.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/homepage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String photoUrl = req.getParameter("photoUrl");
        String quantityStr =req.getParameter("quantity");
        double quantity ;
        String unit = req.getParameter("unit");
        int id = Integer.parseInt(req.getParameter("id"));
        IngredientEntity ingredient;
        String type = req.getParameter("type");
        String text = req.getParameter("text");
        if(quantityStr == null){
            quantity = 0 ;
        } else if (quantityStr.equals("")) {
            quantity = 0 ;
        }else{
            quantity = Double.parseDouble(quantityStr);
        }
        RecipeEntity recipe = DaoFactory.getRecipeDAO().findById(id).get();

        if (type.equals("ingr")){
            List<IngredientEntity> foundIngredients = DaoFactory.getIngredientDAO().findByField("name", name);
            if (foundIngredients.size()==0){
                ingredient = new IngredientEntity(name,photoUrl,null);
                DaoFactory.getIngredientDAO().create(ingredient);
            }else {
                ingredient = foundIngredients.get(0);
            }
            DaoFactory.getRecipeIngredientDAO().create(new RecipeIngredientEntity(quantity, unit,ingredient,recipe));
        }else {
            int stepsNumber = Integer.parseInt(req.getParameter("stepsNumber"))+1;
            DaoFactory.getStepDAO().create(new StepEntity(stepsNumber,text,recipe));
        }
        resp.sendRedirect(req.getContextPath() + "/StepIngredient/Update?id=" +id);

    }
}
