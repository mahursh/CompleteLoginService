package com.mft.completeloginservice.controller.api;

import com.mft.completeloginservice.controller.exception.DuplicateDataException;
import com.mft.completeloginservice.controller.validation.BeanValidation;
import com.mft.completeloginservice.model.entity.Person;
import com.mft.completeloginservice.model.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NoContentException;
import jakarta.ws.rs.core.Response;


@Path("/person")
@SuppressWarnings("Duplicates")

public class PersonApi {
    @Inject
    private PersonService personService;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Person person) {
        try {
            BeanValidation<Person> validator = new BeanValidation<>();
            if (validator.validate(person) == null) {
                return Response.ok().entity(personService.save(person)).build();
            }else {
                return Response.status(500).entity(validator.validate(person)).build();
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
    public Response edit(Person person) {

        try {
            BeanValidation<Person> validator = new BeanValidation<>();
            if (validator.validate(person) == null){
            return Response.ok().entity(personService.edit(person)).build();
            }else {
                return Response.status(500).entity(validator.validate(person)).build();
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
            return Response.ok().entity(personService.remove(id)).build();
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
            return Response.ok().entity(personService.findAll()).build();
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
            // if we consider id as String
            //return Response.ok().entity(personService.findById(Long.valueOf(id))).build();

            return Response.ok().entity(personService.findById(id)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}/{family}")
    public Response findByNameAndFamily(@PathParam("name") String name,
                                        @PathParam("family") String family) {

        try {
            return Response.ok().entity(personService.findByNameAndFamily(name, family)).build();
        } catch (NoContentException e) {
            return Response.status(204).entity("{\"message\": \"" + e.getMessage() + "\"}").build();

        } catch (Exception e) {
            return Response.status(500).entity("{\"message\": \"" + e.getMessage() + "\"}").build();
        }

    }

}
