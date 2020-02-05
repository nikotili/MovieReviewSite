package al.unyt.edu.advjava.fall2019.project.persistence.auth;

import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

public interface AuthenticationManager {
    MovieGoer tryAuth(String email, String password) throws SecurityException;
}
