package al.unyt.edu.advjava.fall2019.project.persistence.auth;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.DaoFactory;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

final class DefaultAuthenticationManager implements AuthenticationManager {

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
