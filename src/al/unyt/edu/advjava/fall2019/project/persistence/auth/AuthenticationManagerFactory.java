package al.unyt.edu.advjava.fall2019.project.persistence.auth;

public final class AuthenticationManagerFactory {
    private static final AuthenticationManager AUTHENTICATION_MANAGER;

    static {
        AUTHENTICATION_MANAGER = new DefaultAuthenticationManager();
    }

    private AuthenticationManagerFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static AuthenticationManager getDefaultAuthenticationManager() {
        return AUTHENTICATION_MANAGER;
    }

}
