package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class UserRepository {
    @PersistenceContext
    EntityManager em;

    public List<User> findAll() {
        return em.createNamedQuery("User.findAll").getResultList();
    }
}
