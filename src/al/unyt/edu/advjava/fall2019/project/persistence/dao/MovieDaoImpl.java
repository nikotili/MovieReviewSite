package al.unyt.edu.advjava.fall2019.project.persistence.dao;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.MovieDao;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public Map<String, String> getMovieRatings() {
        Map<String, String> movieRatings = new HashMap<>();
        movieRatings.put("G", "General Audience");
        movieRatings.put("PG", "Parental Guidance Suggested");
        movieRatings.put("PG13", "Parents Strongly Cautioned");
        movieRatings.put("R", "Restricted");
        movieRatings.put("GNC17", "Adults Only");
        movieRatings.put("NR", "Not Rated");

        return movieRatings;
    }

    @Override
    public List<String> getMovieGenres() {
        List<String> movieGenres = new ArrayList<>();

        movieGenres.add("Action");
        movieGenres.add("Comedy");
        movieGenres.add("Thriller");
        movieGenres.add("Horror");
        movieGenres.add("Romance");
        movieGenres.add("Adventure");
        movieGenres.add("Drama");
        movieGenres.add("Documentary");
        movieGenres.add("Sci-Fi");
        movieGenres.add("Animation");

        return movieGenres;
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
        EntityManager entityManager = entityManagerSupplier.get();
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
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
