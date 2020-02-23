package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.FacesUtil;
import al.unyt.edu.advjava.fall2019.project.faces.manager.session.DefaultSessionManager;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class RegisterBean {

    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean duplicateEmailProvided;

    @PostConstruct
    public void init() {
        if (DefaultSessionManager.getInstance().hasLoggedUser())
            FacesUtil.redirect(FacesUtil.INDEX_URI);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public void register() {
        MovieGoer movieGoer = new MovieGoer();
        movieGoer.setName(name);
        movieGoer.setSurname(surname);
        movieGoer.setEmail(email);
        movieGoer.setPassword(password);
        try {
            setDuplicateEmailProvided(false);
            DefaultAppController.getInstance().registerMovieGoer(movieGoer);
            FacesUtil.redirect(FacesUtil.LOGIN_URI);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            setDuplicateEmailProvided(true);
        }
    }

    public boolean isDuplicateEmailProvided() {
        return duplicateEmailProvided;
    }

    public void setDuplicateEmailProvided(boolean duplicateEmailProvided) {
        this.duplicateEmailProvided = duplicateEmailProvided;
    }
}
