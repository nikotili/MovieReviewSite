package al.unyt.edu.advjava.fall2019.project.persistence.dao;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.MovieDao;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Map;

final class MovieDaoImpl implements MovieDao {

    @Override
    public Map<Movie, Double> getMovieAvgRatings() throws PersistenceException {
        return null;
    }

    @Override
    public List<Movie> getMoviesByAverageRatingRange(double min, double max) throws PersistenceException {
        return null;
    }

    @Override
    public List<Movie> getAll() throws PersistenceException {
        return entityManagerSupplier
                .get()
                .createNamedQuery("Movie.findAll", Movie.class)
                .getResultList();
    }

    @Override
    public void persist(Movie movie) throws PersistenceException {

    }

    @Override
    public Movie getByPK(Integer primaryKey) throws PersistenceException {
        return null;
    }

    @Override
    public void delete(Movie movie) throws PersistenceException {

    }

    @Override
    public List<Movie> getByColumnName(String columnName, String value) throws PersistenceException {
        return null;
    }
}
