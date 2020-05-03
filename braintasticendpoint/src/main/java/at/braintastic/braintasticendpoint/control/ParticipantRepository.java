package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.Participant;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@ApplicationScoped
public class ParticipantRepository {
    @PersistenceContext
    EntityManager em;
    public Participant findById(long participantId) {
        return null;
    }

    public Participant findByName(String userName) {
        return em.createNamedQuery("Participant.findByName", Participant.class)
                .setParameter("NAME", '%' + userName + '%').
                        getSingleResult();
    }

    public void insertParticipant(Participant p) {
        em.merge(p);
    }

    public List<Participant> findAll() {
        return em.createNamedQuery("Participant.findAll", Participant.class)
                .getResultList();
    }
}
