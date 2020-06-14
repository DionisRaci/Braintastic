package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Idea.findAll",
                query = "select i from Idea i"
        ),
})
@Table(name = "BT_Idea")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private int points;

    public Idea(){}

    public Idea(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    /*public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }*/

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints() {
        this.points+=1;
    }

}