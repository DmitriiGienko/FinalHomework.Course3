package DaoImpl;

import Dao.UserDao;
import pojo.Role;
import pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUserWithRoles(User user, List<Role> roleList) {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        user.setRoleList(roleList);
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
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
//        List<Role> roleList = entityManager.find()
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }
}
