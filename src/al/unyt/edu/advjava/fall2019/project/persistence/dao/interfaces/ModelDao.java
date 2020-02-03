package al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces;

import javax.persistence.PersistenceException;
import java.util.List;

public interface ModelDao<Entity, PK> {
    List<Entity> getAll() throws PersistenceException;

    void persist(Entity entity) throws PersistenceException;

    Entity getByPK(PK primaryKey) throws PersistenceException;

    void delete(Entity entity) throws PersistenceException;

    List<Entity> getByColumnName(String columnName, String value) throws PersistenceException;
}
