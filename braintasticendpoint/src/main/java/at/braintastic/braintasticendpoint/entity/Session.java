package at.braintastic.braintasticendpoint.entity;

import javax.persistence.*;

@Entity
public class Session {
    @Id
    private long id;

    @ManyToOne
    private User user;
}
