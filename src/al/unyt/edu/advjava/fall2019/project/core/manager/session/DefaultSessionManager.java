package al.unyt.edu.advjava.fall2019.project.core.manager.session;

import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public final class DefaultSessionManager implements SessionManager {
    private static final DefaultSessionManager INSTANCE;
    private static final String USER_KEY = "USER";

    static {
        INSTANCE = new DefaultSessionManager();
    }

    private DefaultSessionManager() { }

    public static DefaultSessionManager getInstance() {
        return INSTANCE;
    }


    public void createSession(MovieGoer user) {

        final HttpSession session = getSession(true);
        session.setAttribute(USER_KEY, user);
    }

    private HttpSession getSession(boolean create) {
        return (HttpSession) getExternalContext()
                    .getSession(create);
    }

    private ExternalContext getExternalContext() {
        return FacesContext
                .getCurrentInstance()
                .getExternalContext();
    }

    public void invalidateSession() {
        getExternalContext()
                .invalidateSession();
    }

    public void redirect(String url) {
        try {
            getExternalContext().redirect(url);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean hasLoggedUser() {
        try {
            return getLoggedInUser() != null;
        }
        catch (NullPointerException e) {
            System.err.println("No active session!");
            return false;
        }
    }

    public MovieGoer getLoggedInUser() {
        return (MovieGoer) getSession(false)
                .getAttribute(USER_KEY);
    }

}
