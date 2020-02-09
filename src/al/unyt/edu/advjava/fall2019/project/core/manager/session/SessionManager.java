package al.unyt.edu.advjava.fall2019.project.core.manager.session;

import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

public interface SessionManager {

    void createSession(MovieGoer user);

    void invalidateSession();

    boolean hasLoggedUser();

    MovieGoer getLoggedInUser();
}
