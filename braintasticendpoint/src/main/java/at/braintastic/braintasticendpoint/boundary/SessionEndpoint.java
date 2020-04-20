package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.SessionRepository;
import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.Idea;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Session")
public class SessionEndpoint {
    @Inject
    SessionRepository sessionRepository;
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Session> getAllSession() {
        return sessionRepository.findAll();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Idea> getAllIdeaInSession(@PathParam("id") Long id) {
        return sessionRepository.findAllIdeas(id);
    }
}
