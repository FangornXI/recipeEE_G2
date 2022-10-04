package com.example.recipeee_g2.api;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.dao.ObjectDAO;
import com.example.recipeee_g2.entity.RecipeIngredientEntity;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/RecipeIngredients")
public class RecipeIngredientRessource {
    private ObjectDAO<RecipeIngredientEntity> objectDAO;

    public RecipeIngredientRessource() {
        this.objectDAO = DaoFactory.getRecipeIngredientDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<RecipeIngredientEntity> objectList = objectDAO.findAll();
        return Response.ok(objectList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRecipeIngredientById(@PathParam("id") int idParam) {
        Optional<RecipeIngredientEntity> optionalObject = objectDAO.findById(idParam);

        if (optionalObject.isPresent()) {
            return Response.ok(optionalObject.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(RecipeIngredientEntity dto, @Context UriInfo uriInfo) {
        RecipeIngredientEntity createdObject = new RecipeIngredientEntity(dto.getId(),dto.getQuantity(),dto.getUnit(),dto.getIngredientByIngId(),dto.getRecipeByRecipeId());

        objectDAO.create(createdObject);

        URI location = uriInfo
                .getRequestUriBuilder()
                .path(String.valueOf(createdObject.getId()))
                .build();

        return Response.created(location).entity(createdObject).build();
    }


    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int idParam, RecipeIngredientEntity dto) {
        Optional<RecipeIngredientEntity> optionalObject = objectDAO.findById(idParam);
        if (optionalObject.isPresent()) {
            objectDAO.edit(new RecipeIngredientEntity(idParam,dto.getQuantity(),dto.getUnit(),dto.getIngredientByIngId(),dto.getRecipeByRecipeId()));
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
        objectDAO.delete(idParam);
        return Response.noContent().build();
    }
}
