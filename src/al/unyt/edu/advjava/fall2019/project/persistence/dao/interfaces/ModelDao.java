package al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces;

import al.unyt.edu.advjava.fall2019.project.persistence.PersistenceUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.function.Supplier;

public interface ModelDao<Entity, PK> {

    Supplier<EntityManager> entityManagerSupplier = PersistenceUtils::newDefaultEntityManager;

    List<Entity> getAll() throws PersistenceException;

    void persist(Entity entity) throws PersistenceException;

    Entity getByPK(PK primaryKey) throws PersistenceException;

    void delete(Entity entity) throws PersistenceException;

    List<Entity> getByColumnName(String columnName, String value) throws PersistenceException;
}
