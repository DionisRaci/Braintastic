package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.Participant;
import at.braintastic.braintasticendpoint.entity.Session;
import at.braintastic.braintasticendpoint.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class ParticipantRepository {
    @PersistenceContext
    EntityManager em;

    @Inject
    SessionRepository sessionRepository;

    public Participant findById(long participantId) {
        return null;
    }

    public Participant findByName(String userName) {
        return em.createNamedQuery("Participant.findByName", Participant.class)
                .setParameter("NAME", '%' + userName + '%')
                .getSingleResult();
    }

    public Participant findByNameInSession(String userName, long sessionId) {
        List<Participant> participants = sessionRepository.findAllParticipants(sessionId);
        for (Participant p: participants) {
            if (p.getName().equals(userName)){
                return p;
            }
        }
        User u = sessionRepository.findHost(sessionId);
        if (u.getName().equals(userName)){
            Participant p = new Participant(userName);
            p = insertParticipant(p);
            sessionRepository.addParticipant(p, sessionId);
            Session s = sessionRepository.findById(sessionId);
            s.decreaseCount();
            em.merge(s);
            return p;
        }
        return null;
    }

    public Participant insertParticipant(Participant p) {
        return em.merge(p);
    }

    public List<Participant> findAll() {
        return em.createNamedQuery("Participant.findAll", Participant.class)
                .getResultList();
    }

    public List findAllIdeasByParticipant(long id) {
        return em.createNamedQuery("Participant.findIdeas")
                .setParameter("ID", id)
                .getResultList();
    }

    public void removeParticipant(Participant p) {
        em.remove(p);
        em.flush();
    }
}
