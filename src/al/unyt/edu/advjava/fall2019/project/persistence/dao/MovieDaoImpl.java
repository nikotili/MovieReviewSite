package al.unyt.edu.advjava.fall2019.project.persistence.dao;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.MovieDao;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Rating;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.*;

final class MovieDaoImpl implements MovieDao {

    @Override
    public Map<Movie, Double> getMovieAvgRatings() throws PersistenceException {
        return null;
    }

    @Override
    public Collection<Movie> getMoviesByAverageRatingRange(double min, double max) throws PersistenceException {
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
    public Collection<String> getMovieGenres() {
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
    public Collection<Movie> getAll() throws PersistenceException {
        return entityManagerSupplier
                .get()
                .createNamedQuery("Movie.findAll", Movie.class)
                .getResultList();
    }


    @Override
    public void delete(Movie movie) throws PersistenceException {
        EntityManager entityManager = entityManagerSupplier.get();
        try {
            entityManager.getTransaction().begin();
            if (!entityManager.contains(movie)) {
                movie = entityManager.merge(movie);
            }

            TypedQuery<Rating> deleteRatingsByMovieID = entityManager.createNamedQuery("Rating.deleteRatingsByMovieID", Rating.class);
            deleteRatingsByMovieID.setParameter("movieId", movie.getId());
            deleteRatingsByMovieID.executeUpdate();

            entityManager.remove(movie);
            entityManager.getTransaction().commit();
        }
        finally {
            if (entityManager != null)
                entityManager.close();
        }
    }

    @Override
    public Collection<Movie> getByColumnName(String columnName, String value) throws PersistenceException {
        return null;
    }
}
