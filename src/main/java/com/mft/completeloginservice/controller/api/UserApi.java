package com.mft.completeloginservice.controller.api;

import com.mft.completeloginservice.controller.exception.DuplicateDataException;
import com.mft.completeloginservice.controller.validation.BeanValidation;
import com.mft.completeloginservice.model.entity.User;
import com.mft.completeloginservice.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;


@Path("/user")
@SuppressWarnings("Duplicates")
@Slf4j
public class UserApi {
    @Inject
    UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(User user) {
        try {
            BeanValidation<User> validator = new BeanValidation<>();
            //من نمیخوام بدون هش کردن رمز بشه user رو ذخیره کرد :todo
            if (validator.validate(user) == null) {

                return Response.ok().entity(userService.save(user)).build();
            }else {
                return Response.status(500).entity(validator.validate(user)).build();

            }
        }catch (DuplicateDataException e){
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
        catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(User user) {
        try {
            BeanValidation<User> validator = new BeanValidation<>();

            if (validator.validate(user) == null){
                return Response.ok().entity(userService.edit(user)).build();

            }else{
                return Response.status(500).entity(validator.validate(user)).build();

            }
        }catch (DuplicateDataException e){
            return Response.status(203).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
        catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response remove(@PathParam("id") Long id) throws Exception {
        log.info("User Delete api : " + id);
        try {
            return Response.ok().entity(userService.remove(id)).build();
        }catch (NoContentException e){
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
        catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return Response.ok().entity(userService.findAll()).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        try {
            return Response.ok().entity(userService.findById(id)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        } catch (Exception e) {
            return Response.status(204).entity("\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userName}")
    public Response findByUserName(@PathParam("userName") String userName) {
        try {
            return Response.ok().entity(userService.findByUserName(userName)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        } catch (Exception e) {
            return Response.status(204).entity("\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userName}/{password}")
    public Response FindByUserNameAndPassword(@PathParam("userName") String userName,
                                              @PathParam("password") String password) {

        try {
            return Response.ok().entity(userService.findByUserNameAndPassword(userName, password)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }


}
