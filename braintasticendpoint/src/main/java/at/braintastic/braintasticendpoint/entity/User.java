package at.braintastic.braintasticendpoint.entity;
import at.braintastic.braintasticendpoint.utility.PasswordHash;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
@Table(name = "BT_User")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        try {
            this.password = PasswordHash.createHash(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
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
        try {
            this.password = PasswordHash.createHash(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
