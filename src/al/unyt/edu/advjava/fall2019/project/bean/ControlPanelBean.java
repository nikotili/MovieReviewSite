package al.unyt.edu.advjava.fall2019.project.bean;

import al.unyt.edu.advjava.fall2019.project.manager.SessionManager;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ControlPanelBean {

    private final SessionManager sessionManager = SessionManager.getInstance();

    public String logOutAction() {
        sessionManager
                .invalidateSession();

        return BeanUtil.INDEX_URI;
    }

    private boolean isUserLoggedIn() {
        return sessionManager.hasLoggedUser();
    }

    public boolean isUserPanelRendered() {
        return isUserLoggedIn();
    }

    public boolean isLogInRendered() {
        return !isUserLoggedIn();
    }

    public String getUserFullName() {
        MovieGoer user = sessionManager.getLoggedInUser();

        return user.fullName();
    }
}
