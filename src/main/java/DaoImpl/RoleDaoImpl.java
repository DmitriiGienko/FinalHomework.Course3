package DaoImpl;

import Dao.RoleDao;
import pojo.Role;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Override
    public void addRole(Role role) {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Role> getAllRoles() {
        EntityManager entityManager = EntityUtil.getEM();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT e FROM Role e";
        TypedQuery<Role> query = entityManager.createQuery(jpqlQuery, Role.class);
        List<Role> roleList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return roleList;
    }

}
