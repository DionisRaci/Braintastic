package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> BackendSessionDev
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
<<<<<<< HEAD
public class Participant {
=======
public class Participant{
>>>>>>> BackendSessionDev
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

<<<<<<< HEAD
    @OneToMany
    List<Idea> Ideas = new LinkedList<Idea>();
=======
    @OneToMany(fetch = FetchType.EAGER)
    private List<Idea> ideas = new ArrayList<>();


    public Participant() {}

    public Participant(String name) {
        this.name = name;
    }
>>>>>>> BackendSessionDev

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
<<<<<<< HEAD
        return Ideas;
    }

    public void setIdea(Idea idea) {
        Ideas.add(idea);
    }
=======
        return ideas;
    }

    public void insertIdea(Idea idea){
        ideas.add(idea);
    }

    public void setIdea(List<Idea> idea) {
        this.ideas = idea;
    }


>>>>>>> BackendSessionDev
}
