package com.example.recipeee_g2.api;

import com.example.recipeee_g2.dao.DaoFactory;
import com.example.recipeee_g2.dao.ObjectDAO;
import com.example.recipeee_g2.entity.StepEntity;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/Steps")
public class StepRessource {
    private ObjectDAO<StepEntity> objectDAO;

    public StepRessource() {
        this.objectDAO = DaoFactory.getStepDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<StepEntity> objectList = objectDAO.findAll();
        return Response.ok(objectList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStepById(@PathParam("id") int idParam) {
        Optional<StepEntity> optionalObject = objectDAO.findById(idParam);

        if (optionalObject.isPresent()) {
            return Response.ok(optionalObject.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(StepEntity dto, @Context UriInfo uriInfo) {
        StepEntity createdObject = new StepEntity(dto.getId(),dto.getStepNumber(),dto.getText(),dto.getRecipeByRecipeId());

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
    public Response update(@PathParam("id") int idParam, StepEntity dto) {
        Optional<StepEntity> optionalObject = objectDAO.findById(idParam);
        if (optionalObject.isPresent()) {
            objectDAO.edit(new StepEntity(idParam,dto.getStepNumber(),dto.getText(),dto.getRecipeByRecipeId()));
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
