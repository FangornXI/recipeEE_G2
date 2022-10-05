package com.example.recipeee_g2.servlet;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@WebServlet("/recipe/create")
public class CreateUpdateRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<StepEntity> steps = DaoFactory.getStepDAO().findAll();
        List<IngredientEntity> ingredients = DaoFactory.getIngredientDAO().findAll();

        req.setAttribute("authorId", req.getParameter("author"));
        req.setAttribute("steps", steps);
        req.setAttribute("ingredients", ingredients);
        req.getRequestDispatcher("/WEB-INF/createUpdateRecipeForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String description = req.getParameter("description");
        String photoUrl = req.getParameter("photoUrl");
        String dificulty = req.getParameter("dificulty");
        String price = req.getParameter("price");
        int prepTime = Integer.parseInt(req.getParameter("prepTime"));
        int restTime = Integer.parseInt(req.getParameter("restTime"));
        int cookTime = Integer.parseInt(req.getParameter("cookTime"));
        String[] ingredient = req.getParameterValues("ingredient");
        String step = req.getParameter("step");
        String authorId = req.getParameter("author");

        UserEntity authorFound = null;
        try {
            Optional<UserEntity> author = DaoFactory.getUserDAO().findById(Integer.parseInt(authorId));

            if (author.isPresent()){
                authorFound = author.get();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        try {
            RecipeEntity newRecipe = new RecipeEntity(name, type, description, photoUrl, dificulty, price, prepTime, restTime, cookTime, null, null, authorFound, null, null);
            DaoFactory.getRecipeDAO().create(newRecipe);

            Collection<IngredientEntity> ingredients = null;
            for (String item: ingredient){
                try {
                    Optional<IngredientEntity> ingredientToFound = DaoFactory.getIngredientDAO().findById(Integer.parseInt(item));
                    if (ingredientToFound.isPresent()){
                        ingredients.add(ingredientToFound.get());
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            };

            ingredients.forEach( i -> {
                RecipeIngredientEntity ri = new RecipeIngredientEntity(Double.parseDouble(req.getParameter(i.getName() + "Qte")), req.getParameter(i.getName()+"Unit"), i, newRecipe);
                DaoFactory.getRecipeIngredientDAO().create(ri);
            });

        }catch (Exception e){
            e.printStackTrace();
        }





        System.out.println("toto");

    }
}
