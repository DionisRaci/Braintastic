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
        @NamedQuery(
                name = "Session.findAllParticipants",
                query = "select s.participants from Session s where s.id = :ID"
        ),
        @NamedQuery(
                name = "Session.findHost",
                query = "select s.host from Session s where s.id = :ID"
        ),
})
@Table(name = "BT_Session", schema = "braintasticdb")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int participantCount = 0;

    @ManyToOne
    private User host;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Participant> participants = new ArrayList<>();

    public Session(){
    }

    public Session(String name, User host){
        this.name = name;
        this.host = host;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getHost() { return host; }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
        this.participantCount = participants.size();
    }

    public void insertParticipant(Participant p) {
        if (participants.contains(p)) return;
        participants.add(p);
        participantCount++;
    }

    public int getParticipantCount() {
        return this.participantCount;
    }

    public void removeParticipant(Participant p) {
        participants.remove(p);
        decreaseCount();
    }

    public void decreaseCount() {
        this.participantCount--;
    }
}
