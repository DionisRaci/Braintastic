package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.SessionRepository;
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Session")
public class SessionEndpoint {
    @Inject
    SessionRepository sessionRepository;

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getSessionById(@PathParam("id") Long id) {
        return null;
    }

}
