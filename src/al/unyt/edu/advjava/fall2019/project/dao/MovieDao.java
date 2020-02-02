package al.unyt.edu.advjava.fall2019.project.dao;

import al.unyt.edu.advjava.fall2019.project.model.Movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MovieDao extends ModelDao<Movie, Integer> {

    Map<Movie, Double> getMovieAvgRatings() throws SQLException;

    List<Movie> getMoviesByAverageRatingRange(double min, double max) throws SQLException;
}
