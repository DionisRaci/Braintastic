package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.Idea;
import at.braintastic.braintasticendpoint.entity.Participant;
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
    ParticipantRepository participantRepository;

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
        Session s = findById(id);
        em.remove(s);
    }

    public void insertUser(long participantId, Long sessionId) {
        Session s = findById(sessionId);
        Participant p = participantRepository.findById(participantId);
        s.insertUser(p);
    }

    public boolean checkUser(String userName, Long sessionId) {
        Session s = findById(sessionId);
        return s.checkusername(userName);
    }
}