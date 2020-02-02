package al.unyt.edu.advjava.fall2019.project.bean;

import al.unyt.edu.advjava.fall2019.project.dao.auth.AuthenticationManagerFactory;

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
            AuthenticationManagerFactory
                    .getAuthenticationManager()
                    .tryAuth(email, password);
        }
        catch (SecurityException e) {
            return e.getMessage();
        }

        return null;
    }
}
