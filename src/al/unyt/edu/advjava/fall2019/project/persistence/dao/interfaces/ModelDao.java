package al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces;

import al.unyt.edu.advjava.fall2019.project.persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.function.Supplier;

public interface ModelDao<Entity, PK> {

    Supplier<EntityManager> entityManagerSupplier = PersistenceUtil::newDefaultEntityManager;

    Collection<Entity> getAll() throws PersistenceException;

    default void persist(Entity entity) throws PersistenceException {
        EntityManager entityManager = entityManagerSupplier.get();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
            throw e;
        }
        finally {
            if (entityManager.isOpen())
                entityManager.close();
        }
    }

    default Entity getByPK(Class<Entity> entityClass, PK primaryKey) throws PersistenceException {
        return entityManagerSupplier.get().find(entityClass, primaryKey);
    }

    default void update(Entity entity) {
        EntityManager entityManager = entityManagerSupplier.get();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        }
        finally {
            if (entityManager.isOpen())
                entityManager.close();
        }
    }

    void delete(Entity entity) throws PersistenceException;

    Collection<Entity> getByColumnName(String columnName, String value) throws PersistenceException;
}
