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

    public List<User> findAll() {
        return em.createNamedQuery("Idea.findAll").getResultList();
    }

    public void insertIdea(Idea idea) {
        em.merge(idea);
    }

    public void insertIdeaByString(String message, String u) {
        Idea idea = new Idea(message, u);
        em.merge(idea);
    }

    public void delete(long id) {
        Idea i = findById(id);
        em.remove(i);;
    }

    private Idea findById(long id) {
        return em.find(Idea.class, id);
    }
}