package al.unyt.edu.advjava.fall2019.project.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

final public class PersistenceUtils {
    public static final String OPERATOR_EQUALS = " = ";
    public static final String OPERATOR_LIKE = " LIKE ";
    private static final String DEFAULT_PERSISTENCE_UNIT_NAME = "movieReview-PU";
    private static final EntityManagerFactory DEFAULT_ENTITY_MANAGER_FACTORY;

    static {
        DEFAULT_ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT_NAME);
    }

    private PersistenceUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static EntityManager newDefaultEntityManager() {
        return DEFAULT_ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
