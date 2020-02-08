package al.unyt.edu.advjava.fall2019.project.manager;

import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


public class SessionManager {
    private static final SessionManager INSTANCE;
    private static final String USER_KEY = "USER";

    static {
        INSTANCE = new SessionManager();
    }


    public static SessionManager getInstance() {
        return INSTANCE;
    }


    public void createSession(MovieGoer user) {

        final HttpSession session = getSession(true);
        session.setAttribute(USER_KEY, user);
    }

    private HttpSession getSession(boolean create) {
        return (HttpSession) FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .getSession(create);
    }

    public void invalidateSession() {
        FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .invalidateSession();
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
