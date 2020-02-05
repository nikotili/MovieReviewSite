package al.unyt.edu.advjava.fall2019.project.bean;

import al.unyt.edu.advjava.fall2019.project.core.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {

    private String email;
    private String password;

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

    public String authenticate() {
        try {
            MovieGoer movieGoer = DefaultAppController
                    .getInstance()
                    .authenticate(email, password);
        }
        catch (SecurityException e) {
            System.err.println(e.getMessage());

            return e.getMessage();
        }
        return null;
    }
}
