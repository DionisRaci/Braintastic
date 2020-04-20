package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Idea.findAll",
                query = "select i from Idea i"
        ),
        @NamedQuery(
                name = "Idea.findBySession",
                query = "select i from Idea i where i.session.id IN :SESSIONID"
        ),
})
@Table(name = "BT_Idea", schema = "braintasticdb")
public class Idea {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String userName;

    @ManyToOne
    private Session session;

    public Idea(){}

    public Idea(String description, String user, Session session) {
        this.description = description;
        this.userName = user;
        this.session = session;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }
}