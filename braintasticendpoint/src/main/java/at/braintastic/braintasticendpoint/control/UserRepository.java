package at.braintastic.braintasticendpoint.control;

import at.braintastic.braintasticendpoint.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class UserRepository {
    @PersistenceContext
    EntityManager em;

    public List<User> findAll() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    public User findByName(String username) {
        return em.createNamedQuery("User.findByName", User.class)
                .setParameter("NAME", '%' + username + '%')
                .getSingleResult();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public void insertUser(User u) {
        em.merge(u);
    }

    public void updateUser(User newUser, User user) {
        user.setName(newUser.getName());
        user.setPassword(newUser.getPassword());
        em.merge(user);
    }

    public void delete(long id) {
        User u = findById(id);
        em.remove(u);
    }
}
