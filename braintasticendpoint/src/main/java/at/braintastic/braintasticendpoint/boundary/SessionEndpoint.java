package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.SessionRepository;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/Session")
public class SessionEndpoint {
    @Inject
    SessionRepository sessionRepository;
}
