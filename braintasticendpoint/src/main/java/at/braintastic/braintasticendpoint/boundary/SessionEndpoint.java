package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.SessionRepository;
<<<<<<< HEAD
import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
=======
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
>>>>>>> 778f299d5de12dc81c8938f7fcaf1606cf29a248

@Path("/Session")
public class SessionEndpoint {
    @Inject
    SessionRepository sessionRepository;
<<<<<<< HEAD
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Session> getAllSession() {
        return sessionRepository.findAll();
    }
=======
>>>>>>> 778f299d5de12dc81c8938f7fcaf1606cf29a248

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
<<<<<<< HEAD
    public Session getSessionById(@PathParam("id") Long id) {
        return sessionRepository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(JsonObject user){
        String userName = "Test12332";
        User u = userRepository.findByName(userName);
        Session s = new Session(u);
        sessionRepository.insertSession(s);
        return Response.status(200).build();
    }
=======
    public User getSessionById(@PathParam("id") Long id) {
        return null;
    }

>>>>>>> 778f299d5de12dc81c8938f7fcaf1606cf29a248
}
