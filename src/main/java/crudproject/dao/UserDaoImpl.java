package crudproject.dao;

import crudproject.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;


    @Override
    public List<User> index() {
            return entityManager.createQuery("SELECT p FROM User p", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        TypedQuery<User> typeQ = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id = :id",
                User.class
        );
        typeQ.setParameter("id", id);
        return typeQ.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void save(User user) {
      entityManager.persist(user);
    }

    @Override
    public User update(User user) {

           return entityManager.merge(user);


    }

    @Override
    public void delete(int id) {
    entityManager.remove(show(id));
    }
}
