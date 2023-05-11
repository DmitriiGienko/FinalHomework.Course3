package DaoImpl;

import Dao.UserDao;
import pojo.Role;
import pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
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
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        User userForUpdate = entityManager.find(User.class, id);
        userForUpdate.setName(user.getName());
        userForUpdate.setLogin(user.getLogin());
        userForUpdate.setPassword(user.getPassword());
        userForUpdate.setDateTimeOfCreation(LocalDateTime.now());
        entityManager.merge(userForUpdate);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteUser(User user) {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        User userForDelete = entityManager.find(User.class, user.getUserId());
        entityManager.remove(userForDelete);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User getUserById(int id) {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public void getUserByIdWithRoles(int id) {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        System.out.print("Пользователь " + user + " c ролями: ");
        user.getRoleList().forEach(a -> System.out.print(a + " "));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void getUsersByRoles(int roleId) {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        Role role = entityManager.find(Role.class, roleId);
        System.out.println("Роль " + role + " у сотрудников: ");
        role.getUserList().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
