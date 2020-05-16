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
public class IdeaRepository {
    @PersistenceContext
    EntityManager em;

    public List<Idea> findAll() {
<<<<<<< HEAD
        return em.createNamedQuery("Idea.findAll").getResultList();
=======
        return em.createNamedQuery("Idea.findAll", Idea.class).getResultList();
>>>>>>> BackendSessionDev
    }

    public Idea insertIdea(Idea idea) {
        return em.merge(idea);
    }

<<<<<<< HEAD
    public void insertIdeaByString(String message) {
        Idea idea = new Idea(message);
        em.merge(idea);
    }
=======
>>>>>>> BackendSessionDev

    public void delete(long id) {
        Idea i = findById(id);
        em.remove(i);;
    }

    private Idea findById(long id) {
        return em.find(Idea.class, id);
    }
}
