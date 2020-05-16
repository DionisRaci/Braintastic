package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.SessionRepository;
import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
        String userName = user.getString("userName");
        String name = user.getString("name");
        User u = userRepository.findByName(userName);
        Session s = new Session(name, u);
        sessionRepository.insertSession(s);
        return Response.status(200, "test").header("sessionId", s.getId()).build();
    }


    @POST
    @Path("addParticipant/{sessionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addParticipant(@PathParam("sessionId") Long sessionId,JsonObject participant){
        String name = participant.getString("name");
        Session s = sessionRepository.addParticipant(name, sessionId);
        return Response.status(200).build();
    }
}
