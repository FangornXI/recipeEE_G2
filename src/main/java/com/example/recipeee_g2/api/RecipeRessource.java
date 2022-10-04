package com.example.recipeee_g2.api;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.dao.ObjectDAO;
import com.example.recipeee_g2.entity.RecipeEntity;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/Recipes")
public class RecipeRessource {
    private ObjectDAO<RecipeEntity> recipeDAO;

    public RecipeRessource() {
        this.recipeDAO = DaoFactory.getRecipeDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<RecipeEntity> recipeList = recipeDAO.findAll();
        return Response.ok(recipeList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRecipeById(@PathParam("id") int idParam) {
        Optional<RecipeEntity> optionalRecipe = recipeDAO.findById(idParam);

        if (optionalRecipe.isPresent()) {
            return Response.ok(optionalRecipe.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(RecipeEntity dto, @Context UriInfo uriInfo) {
        RecipeEntity createdRecipe = new RecipeEntity(dto.getId(),dto.getName(),dto.getType(),dto.getDescription(),dto.getPhotoUrl(),dto.getDificulty(),dto.getPrice(),dto.getPrepTime(),dto.getRestTime(),dto.getCookTime(),dto.getCommentsById(),dto.getCookedRecipesById(),dto.getUserByAuthorId(),dto.getRecipeIngredientsById(),dto.getStepsById());

        recipeDAO.create(createdRecipe);

        URI location = uriInfo
                .getRequestUriBuilder()
                .path(String.valueOf(createdRecipe.getId()))
                .build();

        return Response.created(location).entity(createdRecipe).build();
    }


    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int idParam, RecipeEntity dto) {
        Optional<RecipeEntity> optionalRecipe = recipeDAO.findById(idParam);
        if (optionalRecipe.isPresent()) {
            recipeDAO.edit(new RecipeEntity(idParam,dto.getName(),dto.getType(),dto.getDescription(),dto.getPhotoUrl(),dto.getDificulty(),dto.getPrice(),dto.getPrepTime(),dto.getRestTime(),dto.getCookTime(),dto.getCommentsById(),dto.getCookedRecipesById(),dto.getUserByAuthorId(),dto.getRecipeIngredientsById(),dto.getStepsById()));
            return getAll();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response delete(@PathParam("id") int idParam) {
        recipeDAO.delete(idParam);
        return Response.noContent().build();
    }
}
