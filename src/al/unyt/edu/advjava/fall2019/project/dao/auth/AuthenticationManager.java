package al.unyt.edu.advjava.fall2019.project.dao.auth;

public interface AuthenticationManager {
    void tryAuth(String email, String password) throws SecurityException;
}
