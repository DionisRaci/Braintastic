package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Session.findAll",
                query = "select s from Session s"
        ),
})
@Table(name = "BT_Session", schema = "braintasticdb")
public class Session {
    @Id
    private long id;

    @ManyToOne
    private User host;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Participant> participants = new ArrayList<>();

    public Session(){
    }

    public Session(User host){
        this.host = host;
    }

    public long getId() {
        return id;
    }

    public User getHost() { return host; }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public void insertParticipant(Participant p) {
        participants.add(p);
    }
}
