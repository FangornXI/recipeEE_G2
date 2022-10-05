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

@WebServlet({"/recipe/Create","/recipe/Update"})
public class CreateUpdateRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id") == null){
            req.setAttribute("user", null);
            req.setAttribute("typeC", "Create");
            req.getRequestDispatcher("/WEB-INF/createUpdateRecipeForm.jsp").forward(req,resp);
        }else{
            String idStr = req.getParameter("id");
            Optional<RecipeEntity> recipe = DaoFactory.getRecipeDAO().findById(Integer.parseInt(idStr));
            if (recipe.isPresent()) {
                req.setAttribute("recipe", recipe.get());
                req.setAttribute("typeC", "Update");
                req.getRequestDispatcher("/WEB-INF/createUpdateRecipeForm.jsp").forward(req,resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/homepage");
            }
        }

//        List<StepEntity> steps = DaoFactory.getStepDAO().findAll();
//        List<IngredientEntity> ingredients = DaoFactory.getIngredientDAO().findAll();
//
//        req.setAttribute("steps", steps);
//        req.setAttribute("ingredients", ingredients);
//        req.getRequestDispatcher("/WEB-INF/createUpdateRecipeForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String description = req.getParameter("description");
        String photoUrl = req.getParameter("photoUrl");
        String dificulty = req.getParameter("dificulty");
        String price = req.getParameter("price");
        String typeC = req.getParameter("typeC");
        int prepTime;
        int restTime;
        int cookTime;
        if (req.getParameter("prepTime").equals("")){
            prepTime = 0 ;
        }else{
            prepTime = Integer.parseInt(req.getParameter("prepTime"));
        }
        if (req.getParameter("restTime").equals("")){
            restTime = 0 ;
        }else{
            restTime = Integer.parseInt(req.getParameter("restTime"));
        }
        if (req.getParameter("cookTime").equals("")){
            cookTime = 0 ;
        }else{
            cookTime = Integer.parseInt(req.getParameter("cookTime"));
        }

        String[] ingredient = req.getParameterValues("ingredient");
        String step = req.getParameter("step");
        String idStr = req.getSession().getAttribute("user").toString();

        UserEntity authorFound = null;
        try {
            Optional<UserEntity> author = DaoFactory.getUserDAO().findById(Integer.parseInt(idStr));

            if (author.isPresent()){
                authorFound = author.get();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if (typeC.equals("Update")){
            int id = Integer.parseInt(req.getParameter("id"));
            RecipeEntity oldrecipe = DaoFactory.getRecipeDAO().findById(id).get();
            RecipeEntity newRecipe = new RecipeEntity(id, name, type, description, photoUrl, dificulty, price, prepTime, restTime, cookTime, oldrecipe.getCommentsById(), oldrecipe.getCookedRecipesById(), authorFound, oldrecipe.getRecipeIngredientsById(), oldrecipe.getStepsById());
            DaoFactory.getRecipeDAO().edit(newRecipe);
            resp.sendRedirect(req.getContextPath() + "/recipe?id=" + id);
        }else {
            RecipeEntity newRecipe = new RecipeEntity(name, type, description, photoUrl, dificulty, price, prepTime, restTime, cookTime, null, null, authorFound, null, null);
            DaoFactory.getRecipeDAO().create(newRecipe);
            resp.sendRedirect(req.getContextPath() + "/recipe?id=" + newRecipe.getId());
        }


//        try {
//
//
//            Collection<IngredientEntity> ingredients = null;
//            for (String item: ingredient){
//                try {
//                    Optional<IngredientEntity> ingredientToFound = DaoFactory.getIngredientDAO().findById(Integer.parseInt(item));
//                    if (ingredientToFound.isPresent()){
//                        ingredients.add(ingredientToFound.get());
//                    }
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            };
//
//            ingredients.forEach( i -> {
//                RecipeIngredientEntity ri = new RecipeIngredientEntity(Double.parseDouble(req.getParameter(i.getName() + "Qte")), req.getParameter(i.getName()+"Unit"), i, newRecipe);
//                DaoFactory.getRecipeIngredientDAO().create(ri);
//            });
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }





//        System.out.println("toto");

    }
}
