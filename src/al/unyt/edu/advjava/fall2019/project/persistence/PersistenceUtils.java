package al.unyt.edu.advjava.fall2019.project.persistence;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

final public class PersistenceUtils {
    public static final String OPERATOR_EQUALS = " = ";
    public static final String OPERATOR_LIKE = " LIKE ";
    private static final String PERSISTENCE_UNIT_NAME = "movieReview-PU";
    private static final EntityManager ENTITY_MANAGER;

    static {
        ENTITY_MANAGER = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    private PersistenceUtils() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    static EntityManager newDefaultEntityManager(String persistenceUnitName) {
        return Persistence.createEntityManagerFactory(persistenceUnitName)
                .createEntityManager();
    }

    public static EntityManager getDefaultEntityManager() {
        return ENTITY_MANAGER;
    }
}
