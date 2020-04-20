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
    @Path("/Token")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getToken() {
        return Response.ok(token).build();
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


    String token = "JraWQiOiIvcHJpdmF0ZUtleS5wZW0iLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3F1YXJrdXMuaW8vdXNpbmctand0LXJiYWMiLCJqdGkiOiJhLTEyMyIsInN1YiI6Impkb2UtdXNpbmctand0LXJiYWMiLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJqZG9lIiwiYXVkIjoidXNpbmctand0LXJiYWMiLCJiaXJ0aGRhdGUiOiIyMDAxLTA3LTEzIiwicm9sZU1hcHBpbmdzIjp7Imdyb3VwMSI6Ikdyb3VwMU1hcHBlZFJvbGUiLCJncm91cDIiOiJHcm91cDJNYXBwZWRSb2xlIn0sImdyb3VwcyI6WyJNZW1iZXIiLCJBZG1pbiIsIkxlYWRlciIsIlN1YnNjcmliZXIiXSwiaWF0IjoxNTg3MzY4OTA2LCJleHAiOjE2MjMzNjg5MDYsImF1dGhfdGltZSI6MTU4NzM2ODkwNn0.kHFPLUn2oVglbKafgCxmn0E3q7uDDH_iKg6F4vPt6gTQi4-348yLdZBl4dyKmRQrRWoiNQGEGpX9VYsWHi5BPO3qrSYr-mznfTWc7P9PMhnoZBq5uGdNjhCmsGJfEWgnvWFaM9Dl2vTczMvouOOUDlURYSa7C35NOFD4sTRMIQDF1qX9JjvKtPhjyWKbqFF8xB8U7gUcLqsUntxU-QR0xNluxtXCN2b-Ewycu0yZ6XQ4sT9cLwpcdKYq5WBnBEA8A6XVnV3BDvJj67xxd4HK0TRgo9LG92uHS0SRUu1n99CokSDVvEwcHlR9nMQRypNv1uYuryuzJvZr_LfLAthg8A\n";
}