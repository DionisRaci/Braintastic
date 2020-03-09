package at.braintastic.braintasticendpoint.entity;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "User.findAll",
                query = "select u from User u"
        ),
        @NamedQuery(
                name = "User.findByName",
                query = "select u from User u where u.name LIKE :NAME"
        )
})
@Table(name = "BT_User", schema = "braintasticdb")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
