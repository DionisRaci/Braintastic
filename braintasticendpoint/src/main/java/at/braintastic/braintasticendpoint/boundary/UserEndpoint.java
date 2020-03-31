package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Status;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/user")
public class UserEndpoint {
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
     /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getGameByNameQuery(@QueryParam("name") String name){
        return userRepository.findByName(name);
    }*/

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(@PathParam("username") String username) {
        return userRepository.findByName(username);
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id) {
        return userRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Context UriInfo info, JsonValue jsonValue) {
        if(jsonValue.getValueType() == JsonValue.ValueType.ARRAY) {
            JsonArray jsonArray = jsonValue.asJsonArray();
            for (JsonValue value : jsonArray) {
                String name = value.asJsonObject().getString("name");
                try {
                    User u = userRepository.findByName(name);
                    if (u != null){
                        return Response.serverError().build();
                    }
                }catch (Exception e){
                    String password = value.asJsonObject().getString("password");
                    User u = new User(name, password);
                    userRepository.insertUser(u);
                }
            }
        }
        else {
            String name = jsonValue.asJsonObject().getString("name");
            try {
                User u = userRepository.findByName(name);
                if(u != null){
                    return Response.serverError().build();
                }
            }catch (Exception e){

                String password = jsonValue.asJsonObject().getString("password");
                User u = new User(name, password);
                userRepository.insertUser(u);
            }
        }
        return Response.status(200).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, User newuser){
        if (newuser == null) return Response.status(400).build();
        User user = userRepository.findById(id);
        if (user == null) return Response.status(400).build();
        userRepository.updateUser(newuser, user);
        return Response.ok(user, MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        try {
            userRepository.delete(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "User with id " + id + " does not exist")
                    .build();
        }
        return Response.noContent().build();
    }
}