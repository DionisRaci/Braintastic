package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Participant.findByName",
                query = "select p from Participant p where p.name LIKE :NAME "
        ),
        @NamedQuery(
                name = "Participant.findAll",
                query = "select p from Participant p"
        ),
})
@Table(name = "BT_Participant", schema = "braintasticdb")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany
    List<Idea> Ideas = new LinkedList<Idea>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Idea> getIdeas() {
        return Ideas;
    }

    public void setIdea(Idea idea) {
        Ideas.add(idea);
    }
}
