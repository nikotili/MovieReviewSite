package al.unyt.edu.advjava.fall2019.project.persistence.dao;

import al.unyt.edu.advjava.fall2019.project.persistence.PersistenceUtils;
import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.MovieGoerDao;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.persistence.PersistenceException;
import java.util.List;

final class MovieGoerDaoImpl implements MovieGoerDao {
    @Override
    public List<MovieGoer> getAll() throws PersistenceException {
        return null;
    }

    @Override
    public void persist(MovieGoer movieGoer) throws PersistenceException {

    }

    @Override
    public MovieGoer getByPK(String primaryKey) throws PersistenceException {
        return PersistenceUtils.getDefaultEntityManager().find(MovieGoer.class, primaryKey);
    }

    @Override
    public void delete(MovieGoer movieGoer) throws PersistenceException {

    }

    @Override
    public List<MovieGoer> getByColumnName(String columnName, String value) throws PersistenceException {
        return null;
    }
}
