package com.example.recipeee_g2.api;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.dao.ObjectDAO;
import com.example.recipeee_g2.entity.IngredientEntity;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/Ingredients")
public class IngredientRessource {
    private ObjectDAO<IngredientEntity> objectDAO;

    public IngredientRessource() {
        this.objectDAO = DaoFactory.getIngredientDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<IngredientEntity> objectList = objectDAO.findAll();
        return Response.ok(objectList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIngredientById(@PathParam("id") int idParam) {
        Optional<IngredientEntity> optionalObject = objectDAO.findById(idParam);

        if (optionalObject.isPresent()) {
            return Response.ok(optionalObject.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(IngredientEntity dto, @Context UriInfo uriInfo) {
        IngredientEntity createdObject = new IngredientEntity(dto.getId(),dto.getName(),dto.getPhotoUrl(),dto.getRecipeIngredientsById());

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
    public Response update(@PathParam("id") int idParam, IngredientEntity dto) {
        Optional<IngredientEntity> optionalObject = objectDAO.findById(idParam);
        if (optionalObject.isPresent()) {
            objectDAO.edit(new IngredientEntity(idParam,dto.getName(),dto.getPhotoUrl(),dto.getRecipeIngredientsById()));
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
