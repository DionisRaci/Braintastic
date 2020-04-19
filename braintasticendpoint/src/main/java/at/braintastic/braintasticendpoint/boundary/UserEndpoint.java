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
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
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
    @Path("/Token")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getToken(){
        return Response.ok("token").build();
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
                        return Response.status(Status.STATUS_UNKNOWN).build();
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
                    return Response.status(Status.STATUS_UNKNOWN).build();
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




    String token = "eyJraWQiOiIvcHJpdmF0ZUtleS5wZW0iLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3F1YXJrdXMuaW8vdXNpbmctand0LXJiYWMiLCJqdGkiOiJhLTEyMyIsInN1YiI6Impkb2UtdXNpbmctand0LXJiYWMiLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJqZG9lIiwiYXVkIjoidXNpbmctand0LXJiYWMiLCJiaXJ0aGRhdGUiOiIyMDAxLTA3LTEzIiwicm9sZU1hcHBpbmdzIjp7Imdyb3VwMSI6Ikdyb3VwMU1hcHBlZFJvbGUifSwiZ3JvdXBzIjpbIlVzZXIiXSwiaWF0IjoxNTg3MzIyMTIwLCJleHAiOjE2MjMzMjIxMjAsImF1dGhfdGltZSI6MTU4NzMyMjEyMH0.kA27pkA-WCs5E0FPok0PzvI3NDpmj1UyY11IqBeUtXPaROlaA9O6_CYN8U0yHAI9QMBDwzrNpDRVu0j9KY7pA6BY1RFskPwWf5wzo4XYqtCJyzMLdwCWd5k0gsqj30o316DIJI4B28S76dD_8TFLnQetQ_HS3mGvCQB7Lojo1vHoOlPoLC4IVfsptCaCOOITB5lzwbDSoqYK1tew9jpSnJibFBzXAJJObqkPSWQyiQ5Zf6peUoYRzTns03VV3Cr4xDv-nuT0FwE2CQofeLdDHmststoA_GVwpZ1I7WRjtqKfOZwWWUeJKLAI2FBIyLY7ExNxASfHsRIX5oOguc7Z2g\n";
}