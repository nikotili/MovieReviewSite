package al.unyt.edu.advjava.fall2019.project.core;

import al.unyt.edu.advjava.fall2019.project.core.interfaces.AppController;
import al.unyt.edu.advjava.fall2019.project.persistence.auth.AuthenticationManagerFactory;
import al.unyt.edu.advjava.fall2019.project.persistence.dao.DaoFactory;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import java.util.List;

public final class DefaultAppController implements AppController {

    private static final DefaultAppController INSTANCE;

    static {
        INSTANCE = new DefaultAppController();
    }

    private DefaultAppController() { }

    public static DefaultAppController getInstance() {
        return INSTANCE;
    }

    @Override
    public MovieGoer authenticate(String email, String password) throws SecurityException {
        return AuthenticationManagerFactory
                .getDefaultAuthenticationManager()
                .tryAuth(email, password);
    }

    @Override
    public List<Movie> getAllMovies() {
        return DaoFactory.getMovieDao().getAll();
    }
}
