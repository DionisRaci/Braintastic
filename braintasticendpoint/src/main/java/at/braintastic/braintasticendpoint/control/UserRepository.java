package at.braintastic.braintasticendpoint.control;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class UserRepository {
    @PersistenceContext
    EntityManager em;
}
