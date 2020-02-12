package al.unyt.edu.advjava.fall2019.project.persistence.dao;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.MovieGoerDao;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.persistence.PersistenceException;
import java.util.Collection;

final class MovieGoerDaoImpl implements MovieGoerDao {
    @Override
    public Collection<MovieGoer> getAll() throws PersistenceException {
        return null;
    }

    @Override
    public void delete(MovieGoer movieGoer) throws PersistenceException {

    }

    @Override
    public Collection<MovieGoer> getByColumnName(String columnName, String value) throws PersistenceException {
        return null;
    }
}
