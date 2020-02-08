package al.unyt.edu.advjava.fall2019.project.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.core.manager.session.DefaultSessionManager;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
    private final DefaultSessionManager sessionManager = DefaultSessionManager.getInstance();
    private String email;
    private String password;

    @PostConstruct
    public void init() {
        if (sessionManager.hasLoggedUser())
            sessionManager.redirect(BeanUtil.INDEX_URI);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void authenticate() {
        try {
            MovieGoer movieGoer = DefaultAppController
                    .getInstance()
                    .authenticate(email, password);

            sessionManager.createSession(movieGoer);
            sessionManager.redirect(BeanUtil.INDEX_URI);

        }
        catch (SecurityException e) {

        }
    }
}
