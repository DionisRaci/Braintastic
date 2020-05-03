package at.braintastic.braintasticendpoint.entity;

import javax.mail.Part;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User host;

    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Participant> participants = new ArrayList<>();

    public Session(){}
    public Session(User user){
        this.host = user;
    }

    public long getId() {
        return id;
    }

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
    }
}
