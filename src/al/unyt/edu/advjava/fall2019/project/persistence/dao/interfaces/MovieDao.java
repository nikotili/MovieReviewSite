package al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces;

import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.Map;

public interface MovieDao extends ModelDao<Movie, Integer> {

    Map<Movie, Double> getMovieAvgRatings() throws PersistenceException;

    Collection<Movie> getMoviesByAverageRatingRange(double min, double max) throws PersistenceException;

    Map<String, String> getMovieRatings();

    Collection<String> getMovieGenres();
}
