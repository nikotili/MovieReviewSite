package al.unyt.edu.advjava.fall2019.project.core.controller;

import al.unyt.edu.advjava.fall2019.project.core.manager.auth.DefaultAuthenticationManager;
import al.unyt.edu.advjava.fall2019.project.persistence.dao.DaoFactory;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Rating;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.eclipse.persistence.exceptions.DatabaseException;

import javax.persistence.PersistenceException;
import java.util.Collection;
import java.util.Map;

public final class DefaultAppController implements AppController {

    private static final DefaultAppController INSTANCE;

    static {
        INSTANCE = new DefaultAppController();
    }

    private DefaultAppController() {}

    public static DefaultAppController getInstance() {
        return INSTANCE;
    }

    @Override
    public MovieGoer authenticate(String email, String password) throws SecurityException {
        return DefaultAuthenticationManager.getInstance()
                .tryAuth(email, password);
    }

    @Override
    public void registerMovieGoer(MovieGoer movieGoer) throws PersistenceException, DatabaseException {
        DaoFactory.getMovieGoerDao().persist(movieGoer);
    }

    @Override
    public Collection<Movie> getAllMovies() {
        return DaoFactory.getMovieDao().getAll();
    }

    @Override
    public Collection<Rating> getAllRatings() {
        return DaoFactory.getRatingDao().getAll();
    }

    @Override
    public void addNewMovie(Movie movie) {
        DaoFactory.getMovieDao().persist(movie);
    }

    @Override
    public Collection<String> getMovieGenres() {
        return DaoFactory.getMovieDao().getMovieGenres();
    }

    @Override
    public Map<String, String> getMovieRatings() {
        return DaoFactory.getMovieDao().getMovieRatings();
    }

    @Override
    public Movie getMovieByPK(Integer id) {
        return DaoFactory.getMovieDao().getByPK(Movie.class, id);
    }

    @Override
    public void updateMovie(Movie movie) {
        DaoFactory.getMovieDao().update(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        DaoFactory.getMovieDao().delete(movie);
    }

    @Override
    public void addRating(Rating rating) {
        DaoFactory.getRatingDao().upsert(rating);
    }
}
