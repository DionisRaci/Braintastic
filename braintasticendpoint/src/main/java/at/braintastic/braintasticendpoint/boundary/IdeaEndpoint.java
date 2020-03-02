package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.IdeaRepository;
import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.Idea;
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
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return ideaRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(JsonObject idea){
        long user_id = (long)(idea.getInt("user_id"));
        String desc = idea.getString("description");
        User u = userRepository.findById(user_id);
        Idea i = new Idea(desc, u);
        ideaRepository.insertIdea(i);
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
