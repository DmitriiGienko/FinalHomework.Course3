package DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtil {


    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("myPersistenceUnit");

    public static EntityManager getEM() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static void closeMF() {
        entityManagerFactory.close();
    }

}
