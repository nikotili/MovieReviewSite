package al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces;

import al.unyt.edu.advjava.fall2019.project.persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.function.Supplier;

public interface ModelDao<Entity, PK> {

    Supplier<EntityManager> entityManagerSupplier = PersistenceUtil::newDefaultEntityManager;

    Collection<Entity> getAll() throws PersistenceException;

    void persist(Entity entity) throws PersistenceException;

    Entity getByPK(PK primaryKey) throws PersistenceException;

    void delete(Entity entity) throws PersistenceException;

    Collection<Entity> getByColumnName(String columnName, String value) throws PersistenceException;
}
