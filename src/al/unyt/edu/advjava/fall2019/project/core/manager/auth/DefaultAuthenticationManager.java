package al.unyt.edu.advjava.fall2019.project.core.manager.auth;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.DaoFactory;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

public final class DefaultAuthenticationManager implements AuthenticationManager {

    private static final DefaultAuthenticationManager AUTHENTICATION_MANAGER;

    static {
        AUTHENTICATION_MANAGER = new DefaultAuthenticationManager();
    }

    private DefaultAuthenticationManager() {}

    public static DefaultAuthenticationManager getInstance() {
        return AUTHENTICATION_MANAGER;
    }

    @Override
    public MovieGoer tryAuth(String email, String password) throws SecurityException {
        MovieGoer movieGoer = DaoFactory
                .getMovieGoerDao()
                .getByPK(email);

        if (movieGoer == null)
            throw new SecurityException("Wrong email!");

        if (!movieGoer.getPassword().equals(password))
            throw new SecurityException("Wrong password!");

        System.out.println("Login OK!");
        return movieGoer;
    }
}
