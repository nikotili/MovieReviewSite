package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.faces.manager.session.DefaultSessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class RequiresLoginBean {

    private MovieController movieController;

    @PostConstruct
    public void init() throws IllegalStateException {

        if (!DefaultSessionManager.getInstance().hasLoggedUser()) {
            FacesUtil.redirect(FacesUtil.LOGIN_URI);
            throw new IllegalStateException("Redirected!");
        }

        movieController = DefaultSessionManager.getInstance().getCurrentMovieController();
    }

    public MovieController getMovieController() {
        return movieController;
    }

    public void setMovieController(MovieController movieController) {
        this.movieController = movieController;
    }
}