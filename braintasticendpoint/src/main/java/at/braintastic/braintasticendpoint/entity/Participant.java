package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "BT_Participant", schema = "braintasticdb")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany
    List<Idea> Ideas = new LinkedList<Idea>();
}
