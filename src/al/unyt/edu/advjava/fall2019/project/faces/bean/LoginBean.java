package al.unyt.edu.advjava.fall2019.project.faces.bean;

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
    private boolean redirectedForValidation;

    @PostConstruct
    public void init() {
        if (sessionManager.hasLoggedUser())
            FacesUtil.redirect(FacesUtil.INDEX_URI);
        else {
            checkRequestParameterValueForErrorMessage();
        }
    }

    private void checkRequestParameterValueForErrorMessage() {
        try {
            String errorParam = FacesUtil.getRequestParameterValue(FacesUtil.LOGIN_ERROR_PARAM);
            setRedirectedForValidation(errorParam !=null && errorParam.equals(FacesUtil.LOGIN_ERROR_ARG));
        } catch (NullPointerException e) {
            setRedirectedForValidation(false);
        }
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
            FacesUtil.redirect(FacesUtil.INDEX_URI);

        }
        catch (SecurityException e) {

        }
    }

    public boolean isRedirectedForValidation() {
        return redirectedForValidation;
    }

    public void setRedirectedForValidation(boolean redirectedForValidation) {
        this.redirectedForValidation = redirectedForValidation;
    }
}
