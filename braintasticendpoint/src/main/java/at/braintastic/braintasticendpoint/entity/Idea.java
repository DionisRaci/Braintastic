package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Idea.findAll",
                query = "select i from Idea i"
        ),
})
@Table(name = "BT_Idea", schema = "braintasticdb")
public class Idea {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String description;

    @ManyToOne
    private User user_id;

    public Idea(){}

    public Idea(String description, User user) {
        this.description = description;
        this.user_id = user;
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

    public User getUser() {
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user;
    }
}