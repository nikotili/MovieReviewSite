package al.unyt.edu.advjava.fall2019.project.dao;

import java.sql.SQLException;
import java.util.List;

public interface ModelDao<Entity, PK> {
    List<Entity> getAll() throws SQLException;

    void persist(Entity entity) throws SQLException;

    Entity getByPK(PK primaryKey) throws SQLException;

    void delete(Entity entity) throws SQLException;

    List<Entity> getByColumnName(String columnName, String value) throws SQLException;
}
