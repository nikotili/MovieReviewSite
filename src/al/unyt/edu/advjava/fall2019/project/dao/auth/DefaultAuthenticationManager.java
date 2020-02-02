package al.unyt.edu.advjava.fall2019.project.dao.auth;

class DefaultAuthenticationManager implements AuthenticationManager {

    @Override
    public void tryAuth(String email, String password) throws SecurityException {
        throw new SecurityException();
    }
}
