package at.braintastic.braintasticendpoint.entity;
import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "User.findAll",
                query = "select u from User u"
        )
)
@Table(name = "BT_User", schema = "braintasticdb")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String name;
    private String password;
}
