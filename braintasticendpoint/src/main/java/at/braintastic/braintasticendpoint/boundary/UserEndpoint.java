package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.User;
import at.braintastic.braintasticendpoint.utility.PasswordHash;

import javax.annotation.security.RolesAllowed;
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
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(@PathParam("username") String username)
    {
        return userRepository.findByName(username);
    }
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendLogin(@Context UriInfo info,JsonValue jsonValue)
    {
        String name = jsonValue.asJsonObject().getString("name");
        try {
            User received  = userRepository.findByName(name);
            String password = jsonValue.asJsonObject().getString("password");
            if(received == null){
                return Response.serverError().build();
            }
            boolean validated = PasswordHash.validatePassword(password,received.getPassword());
            if(validated) return Response.ok(token).build();
        }catch (Exception e){
            return Response.serverError().build();
        }
        return Response.serverError().build();
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


    String token = "eyJraWQiOiIvcHJpdmF0ZUtleS5wZW0iLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJodHRwczovL3F1YXJrdXMuaW8vdXNpbmctand0LXJiYWMiLCJqdGkiOiJhLTEyMyIsInN1YiI6Impkb2UtdXNpbmctand0LXJiYWMiLCJ1cG4iOiJqZG9lQHF1YXJrdXMuaW8iLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJqZG9lIiwiYXVkIjoidXNpbmctand0LXJiYWMiLCJiaXJ0aGRhdGUiOiIyMDAxLTA3LTEzIiwicm9sZU1hcHBpbmdzIjp7Imdyb3VwMSI6Ikdyb3VwMU1hcHBlZFJvbGUifSwiZ3JvdXBzIjpbIlVzZXIiXSwiaWF0IjoxNTg3Mzc0ODA3LCJleHAiOjUxODczNzQ4MDYsImF1dGhfdGltZSI6MTU4NzM3NDgwN30.UruCwvFw35qQ_X7MmhnFuTzRhTXLGbAl70-YLiGBKL46Ae5VhgkXcdLEwAytPB90c_iaDpQO1sq1KBLMR3JCsckjkCXMmqr0CFo_oeEQSwvQf_N7Ytipe-QYI7r1vd5Ss6Z5-iiEEvJkUj60q2kC4XbOHK0Yn5hUZJum8xjjfRoZbttlKDzOZzEv2GU8V-2aMVzQpmJzXlWgOpS4_z765kYQ3mRfIDdlt-zouzokKPzuHVHszJhz4Y-zBjyKRj19K2Bngjq-cYkMLN7dYmn5RKEThPoR4IHiUU5bZAmubQrkOf0D3ZCe3YmVMo1zrV2oWYj4mDcybSCHgbAr1BVyhA\n";
}