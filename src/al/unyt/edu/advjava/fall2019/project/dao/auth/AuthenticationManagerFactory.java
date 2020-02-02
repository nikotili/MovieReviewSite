package al.unyt.edu.advjava.fall2019.project.dao.auth;

public class AuthenticationManagerFactory {
    private static final AuthenticationManager AUTHENTICATION_MANAGER;

    static {
        AUTHENTICATION_MANAGER = new DefaultAuthenticationManager();
    }

    private AuthenticationManagerFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static AuthenticationManager getAuthenticationManager() {
        return AUTHENTICATION_MANAGER;
    }

}
