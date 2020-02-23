package al.unyt.edu.advjava.fall2019.project.core.controller;

import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Rating;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.eclipse.persistence.exceptions.DatabaseException;

import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.Map;

public interface AppController {

    MovieGoer authenticate(String email, String password) throws SecurityException;

    void registerMovieGoer(MovieGoer movieGoer) throws PersistenceException, DatabaseException;

    Collection<Movie> getAllMovies();

    Collection<Rating> getAllRatings();

    void addNewMovie(Movie movie);

    Movie getMovieByPK(Integer id);

    void updateMovie(Movie movie);

    void deleteMovie(Movie movie);

    void addRating(Rating rating);

    Collection<String> getMovieGenres();

    Map<String, String> getMovieRatings();

}