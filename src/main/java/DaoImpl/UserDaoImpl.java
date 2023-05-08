package DaoImpl;

import Dao.UserDao;
import pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
//        return user;
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM User e";
        TypedQuery<User> query = entityManager.createQuery(jpqlQuery, User.class);
        List<User> usersList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return usersList;
    }

    @Override
    public void updateUser(int id, User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User getUserById(int id) {
        return null;
    }
}
