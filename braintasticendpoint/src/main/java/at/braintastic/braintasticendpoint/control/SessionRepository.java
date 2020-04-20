package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.Idea;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
@Transactional
public class SessionRepository {
    @PersistenceContext
    EntityManager em;

    public List<Session> findAll() {
        return em.createNamedQuery("Session.findAll").getResultList();
    }

    public List<Idea> findAllIdeas(long id) {
        return em.createNamedQuery("Idea.findBySession", Idea.class)
                 .setParameter("SESSIONID",  id)
                 .getResultList();
    }

    public User findByName(String username) {
        return em.createNamedQuery("User.findByName", User.class)
                .setParameter("NAME", '%' + username + '%')
                .getSingleResult();
    }

    public Session findById(Long id) {
        return em.find(Session.class, id);
    }

    public void insertSession(Session s) {
        em.merge(s);
    }

    public void delete(long id) {
        Session u = findById(id);
        em.remove(u);
    }
}
