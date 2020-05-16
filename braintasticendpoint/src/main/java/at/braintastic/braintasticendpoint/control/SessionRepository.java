package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.Idea;
import at.braintastic.braintasticendpoint.entity.Participant;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class SessionRepository {
    @PersistenceContext
    EntityManager em;
    @Inject
    ParticipantRepository participantRepository;

    public List<Session> findAll() {
        return em.createNamedQuery("Session.findAll", Session.class).getResultList();
    }

    public List findAllParticipants(long sessionId) {
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

    public void updateHost(User newUser, User user) {
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());
        em.merge(user);
    }

    public void delete(long id) {
        Session u = findById(id);
        em.remove(u);
    }

    public Session addParticipant(String name, Long sessionId) {
        Session s = findById(sessionId);
        Participant p = participantRepository.findByName(name);
        s.insertParticipant(p);
        em.merge(s);
        return s;
    }
    public Session addParticipant(Participant p, Long sessionId) {
        Session s = findById(sessionId);
        s.insertParticipant(p);
        em.merge(s);
        return s;
    }

    public User findHost(long sessionId) {
        return em.createNamedQuery("Session.findHost", User.class)
                .setParameter("ID", sessionId)
                .getSingleResult();
    }

    public List<Idea> findAllIdeas(Long id) {
        List<Participant> participants = findAllParticipants(id);

        List<Idea> ideas = new ArrayList<>();
        for (Participant p: participants) {
            ideas.addAll(participantRepository.findAllIdeasByParticipant(p.getId()));
        }
        return ideas;
    }

    public Session removeParticipant(String name, Long sessionId) {
        Participant p = participantRepository.findByNameInSession(name, sessionId);
        System.out.println("--------------------------------------------------------------" + p.getName());
        Session s = findById(sessionId);
        s.decreaseCount();
        em.merge(s);
        return s;
    }
}
