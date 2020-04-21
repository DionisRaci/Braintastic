package at.braintastic.braintasticendpoint.entity;

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
    private User user;

    @ElementCollection
    List<String> userNames = new LinkedList<String>();

    public Session(){}
    public Session(User user){
        this.user = user;
        userNames.add(user.getName());
    }

    public long getId() {
        return id;
    }

    public User getUser() { return user; }

    public void setUser(User user) {
        this.user = user;
        userNames.add(user.getName());
    }

    public void insertUser(String user) { userNames.add(user); }

    public boolean checkusername(String userName) {
        if (userNames.contains(userName)) return true;
        return false;
    }
}
