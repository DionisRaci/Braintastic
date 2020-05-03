package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.IdeaRepository;
import at.braintastic.braintasticendpoint.control.ParticipantRepository;
import at.braintastic.braintasticendpoint.control.SessionRepository;
import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.Idea;
import at.braintastic.braintasticendpoint.entity.Participant;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;
import netscape.javascript.JSObject;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Idea")
public class IdeaEndpoint {
    @Inject
    IdeaRepository ideaRepository;
    @Inject
    SessionRepository sessionRepository;
    @Inject
    ParticipantRepository participantRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    @GET
    @Path("/sessionId/{sessionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Idea> getAllIdeasBySession(@PathParam("sessionId") Long sessionId) {
        return sessionRepository.findAllIdeas(sessionId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(JsonObject idea){
        String userName = (idea.getString("userName"));
        Participant p = participantRepository.findByName(userName);
        Long sessionId = (long) idea.getInt("sessionId");
        if (!sessionRepository.checkUser(p, sessionId))
        {
            return Response.status(404, "user not found").build();
        }
        String desc = idea.getString("description");
        Idea i = new Idea(desc);
        p.setIdea(i);
        ideaRepository.insertIdea(i);
        participantRepository.insertParticipant(p);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        try {
            ideaRepository.delete(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "Idea with id " + id + " does not exist")
                    .build();
        }
        return Response.noContent().build();
    }
}
