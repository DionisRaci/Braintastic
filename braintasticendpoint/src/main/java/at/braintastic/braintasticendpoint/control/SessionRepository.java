package at.braintastic.braintasticendpoint.control;

<<<<<<< HEAD
import at.braintastic.braintasticendpoint.entity.Idea;
=======
>>>>>>> BackendSessionDev
import at.braintastic.braintasticendpoint.entity.Participant;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;


@ApplicationScoped
@Transactional
public class SessionRepository {
    @PersistenceContext
    EntityManager em;
<<<<<<< HEAD
    ParticipantRepository participantRepository;

    public List<Session> findAll() {
        return em.createNamedQuery("Session.findAll").getResultList();
    }

    public List<Idea> findAllIdeas(long id) {
        return em.createNamedQuery("Idea.findBySession", Idea.class)
                 .setParameter("SESSIONID",  id)
                 .getResultList();
=======
    @Inject
    ParticipantRepository participantRepository;

    public List<Session> findAll() {
        return em.createNamedQuery("Session.findAll", Session.class).getResultList();
>>>>>>> BackendSessionDev
    }

    public List<Participant> findAllParticipants(long sessionId) {
        return em.createNamedQuery("Session.findAllParticipants")
                .setParameter("ID", sessionId)
                .getResultList();
    }

    public Session findById(Long id) {
        return em.find(Session.class, id);
    }

    public Session insertSession(Session s) {
        return em.merge(s);
    }

<<<<<<< HEAD
    public void delete(long id) {
        Session s = findById(id);
        em.remove(s);
=======
    public void updateHost(User newUser, User user) {
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());
        em.merge(user);
>>>>>>> BackendSessionDev
    }

    public void insertUser(long participantId, Long sessionId) {
        Session s = findById(sessionId);
        Participant p = participantRepository.findById(participantId);
        s.insertParticipant(p);
    }

    public boolean checkUser(Participant p, Long sessionId) {
        Session s = findById(sessionId);
        return s.checkParticipant(p);
    }

    public Session addParticipant(String name, Long sessionId) {
        Session s = findById(sessionId);
        Participant p = participantRepository.findByName(name);
        s.insertParticipant(p);
        return em.merge(s);
    }
    public Session addParticipant(Participant p, Long sessionId) {
        Session s = findById(sessionId);
        s.insertParticipant(p);
        return em.merge(s);
    }

    public User findHost(long sessionId) {
        return em.createNamedQuery("Session.findHost", User.class)
                .setParameter("ID", sessionId)
                .getSingleResult();
    }
}
