package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.ParticipantRepository;
import at.braintastic.braintasticendpoint.entity.Participant;

import javax.inject.Inject;
<<<<<<< HEAD
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
=======
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
>>>>>>> BackendSessionDev
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
<<<<<<< HEAD
=======

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Context UriInfo info, @PathParam("id") long id, JsonValue jsonValue) {
        if(jsonValue.getValueType() == JsonValue.ValueType.ARRAY) {
            JsonArray jsonArray = jsonValue.asJsonArray();
            for (JsonValue value : jsonArray) {
                String name = value.asJsonObject().getString("name");
                try {
                    Participant u = participantRepository.findByNameInSession(name,id);
                    if (u != null){
                        return Response.serverError().build();
                    }
                }catch (Exception e){
                    Participant u = new Participant(name);
                    u = participantRepository.insertParticipant(u);
                }
            }
        }
        else {
            String name = jsonValue.asJsonObject().getString("name");
            try {
                Participant u = participantRepository.findByNameInSession(name, id);
                if(u != null){
                    return Response.serverError().build();
                }
            }catch (Exception e){
                Participant u = new Participant(name);
                u = participantRepository.insertParticipant(u);
            }
        }
        return Response.status(200).build();
    }
>>>>>>> BackendSessionDev
}
