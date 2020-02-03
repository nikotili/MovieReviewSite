package al.unyt.edu.advjava.fall2019.project.core;

import al.unyt.edu.advjava.fall2019.project.core.interfaces.AppController;
import al.unyt.edu.advjava.fall2019.project.persistence.auth.AuthenticationManagerFactory;

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
    public void authenticate(String email, String password) throws SecurityException {
        AuthenticationManagerFactory
                .getDefaultAuthenticationManager()
                .tryAuth(email, password);
    }
}
