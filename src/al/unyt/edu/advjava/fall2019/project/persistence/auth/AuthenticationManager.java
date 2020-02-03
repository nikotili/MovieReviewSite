package al.unyt.edu.advjava.fall2019.project.persistence.auth;

public interface AuthenticationManager {
    void tryAuth(String email, String password) throws SecurityException;
}
