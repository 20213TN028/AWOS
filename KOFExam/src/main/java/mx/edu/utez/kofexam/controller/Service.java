package mx.edu.utez.kofexam.controller;

import mx.edu.utez.kofexam.model.character.BeanCharacter;
import mx.edu.utez.kofexam.model.character.DaoCharacter;
import mx.edu.utez.kofexam.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/kof")
public class Service {

    @GET
    @Path("/")
    @Produces(value = {"application/json"})
    public List<BeanCharacter> getAllCharacters() {
        return new DaoCharacter().getAllCharacters();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanCharacter> getById(@PathParam("id") Long id) {
        return new DaoCharacter().getById(id);
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanCharacter> save(BeanCharacter character) {
        return new DaoCharacter().save(character);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanCharacter> update(BeanCharacter character) {
        return new DaoCharacter().update(character);
    }
}
