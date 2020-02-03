package al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces;

import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.persistence.PersistenceException;
import java.util.List;
import java.util.Map;

public interface MovieDao extends ModelDao<Movie, Integer> {

    Map<Movie, Double> getMovieAvgRatings() throws PersistenceException;

    List<Movie> getMoviesByAverageRatingRange(double min, double max) throws PersistenceException;
}
