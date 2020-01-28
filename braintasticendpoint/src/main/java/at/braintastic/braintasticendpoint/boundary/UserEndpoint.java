package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.UserRepository;
import at.braintastic.braintasticendpoint.entity.User;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
public class UserEndpoint {
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}