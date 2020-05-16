package at.braintastic.braintasticendpoint.entity;

import javax.mail.Part;
import javax.persistence.*;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.LinkedList;
=======
>>>>>>> BackendSessionDev
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Session.findAll",
                query = "select s from Session s"
        ),
<<<<<<< HEAD
=======
        @NamedQuery(
                name = "Session.findAllParticipants",
                query = "select s.participants from Session s where s.id = :ID"
        ),
        @NamedQuery(
                name = "Session.findHost",
                query = "select s.host from Session s where s.id = :ID"
        ),
>>>>>>> BackendSessionDev
})
@Table(name = "BT_Session", schema = "braintasticdb")
public class Session {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private User host;

<<<<<<< HEAD
    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Participant> participants = new ArrayList<>();

    public Session(){}
    public Session(User user){
        this.host = user;
=======
    @OneToMany(fetch = FetchType.EAGER)
    private List<Participant> participants = new ArrayList<>();

    public Session(){
    }

    public Session(String name, User host){
        this.name = name;
        this.host = host;
>>>>>>> BackendSessionDev
    }

    public long getId() {
        return id;
    }

<<<<<<< HEAD
    public User getHost() { return host; }

    public List<Participant> getParticipants() {
        if (participants != null) return participants;
        return null;
    }

    public void insertParticipant(Participant p) { participants.add(p); }

    public void setHost(User user) {
        this.host = user;
    }

    public boolean checkParticipant(Participant p) {
        if (participants.contains(p)) return true;
        return false;
=======
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
    }

    public void insertParticipant(Participant p) {
        participants.add(p);
>>>>>>> BackendSessionDev
    }
}
