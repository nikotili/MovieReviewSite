package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.manager.session.DefaultSessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IndexBean {
    private MovieController movieController;


    @PostConstruct
    public void init() {
        movieController = DefaultSessionManager
                .getInstance()
                .getCurrentMovieController();
    }

    public MovieController getMovieController() {
        return movieController;
    }

    public void setMovieController(MovieController movieController) {
        this.movieController = movieController;
    }
}
