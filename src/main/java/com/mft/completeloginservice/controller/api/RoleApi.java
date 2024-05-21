package com.mft.completeloginservice.controller.api;

import com.mft.completeloginservice.controller.exception.DuplicateDataException;
import com.mft.completeloginservice.controller.validation.BeanValidation;
import com.mft.completeloginservice.model.entity.Role;
import com.mft.completeloginservice.model.service.RoleService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;

@Path("/role")
@SuppressWarnings("Duplicates")

public class RoleApi {
    @Inject
    RoleService roleService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Role role) {
        try {
            BeanValidation<Role> validator = new BeanValidation<>();
            if (validator.validate(role) == null) {
                return Response.ok().entity(roleService.save(role)).build();
            } else {
                return Response.status(500).entity(validator.validate(role)).build();
            }
        } catch (DuplicateDataException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Role role) {
        try {
            BeanValidation<Role> validator = new BeanValidation<>();

            if (validator.validate(role) == null) {
                return Response.ok().entity(roleService.edit(role)).build();

            } else {
                return Response.status(500).entity(validator.validate(role)).build();

            }
        } catch (DuplicateDataException e) {
            return Response.status(203).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    // نباید این id رو string در نظر بگیریم؟ todo:
    public Response remove(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(roleService.remove(id)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return Response.ok().entity(roleService.findAll()).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

}
