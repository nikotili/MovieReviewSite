package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.faces.FacesUtil;
import al.unyt.edu.advjava.fall2019.project.faces.manager.session.DefaultSessionManager;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ControlPanelBean {

    private final DefaultSessionManager sessionManager = DefaultSessionManager.getInstance();

    public void logOutAction() {
        sessionManager.invalidateSession();
        FacesUtil.redirect(FacesUtil.INDEX_URI);
    }

    private boolean isUserLoggedIn() {
        return sessionManager.hasLoggedUser();
    }

    public boolean isUserPanelRendered() {
        return isUserLoggedIn();
    }

    public boolean isLogInPanelRendered() {
        return !isUserLoggedIn();
    }

    public String getUserFullName() {
        MovieGoer user = sessionManager.getLoggedInUser();
        return user.fullName();
    }
}
