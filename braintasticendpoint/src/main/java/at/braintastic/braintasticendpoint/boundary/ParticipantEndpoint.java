package at.braintastic.braintasticendpoint.boundary;

import at.braintastic.braintasticendpoint.control.ParticipantRepository;
import at.braintastic.braintasticendpoint.entity.Participant;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Context UriInfo info, JsonValue jsonValue) {
        if(jsonValue.getValueType() == JsonValue.ValueType.ARRAY) {
            JsonArray jsonArray = jsonValue.asJsonArray();
            for (JsonValue value : jsonArray) {
                String name = value.asJsonObject().getString("name");
                try {
                    Participant u = participantRepository.findByName(name);
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
                Participant u = participantRepository.findByName(name);
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
}
