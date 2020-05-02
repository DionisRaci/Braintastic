package at.braintastic.braintasticendpoint.entity;

import javax.mail.Part;
import javax.persistence.*;
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

    @ManyToMany
    List<Participant> participants = new LinkedList<Participant>();

    public Session(){}
    public Session(User user){
        this.host = user;
    }

    public long getId() {
        return id;
    }

    public User getUser() { return host; }

    public void setUser(User user) {
        this.host = user;
    }

    public void insertUser(Participant p) { participants.add(p); }

    public boolean checkusername(String userName) {
        if (participants.contains(userName)) return true;
        return false;
    }
}
