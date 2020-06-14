package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.Idea;
import at.braintastic.braintasticendpoint.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class IdeaRepository {
    @PersistenceContext
    EntityManager em;

    public List<Idea> findAll() {
        return em.createNamedQuery("Idea.findAll", Idea.class).getResultList();
    }

    public Idea insertIdea(Idea idea) {
        return em.merge(idea);
    }

    public void delete(long id) {
        Idea i = findById(id);
        em.remove(i);;
    }

    public Idea findById(long id) {
        return em.find(Idea.class, id);
    }

    public Idea increasePoints(long id) {
        Idea i = findById(id);
        i.increasePoints();
        em.merge(i);
        return i;
    }
}
