package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.ParticipantRepository;
import at.braintastic.braintasticendpoint.entity.Participant;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Participant")
public class ParticipantEndpoint {
    @Inject
    ParticipantRepository participantRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }
}
