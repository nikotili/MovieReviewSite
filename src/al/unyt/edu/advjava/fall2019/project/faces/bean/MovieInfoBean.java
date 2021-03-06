package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.faces.FacesUtil;
import al.unyt.edu.advjava.fall2019.project.faces.controller.MovieController;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.faces.manager.session.DefaultSessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MovieInfoBean {

    private MovieController movieController;

    @PostConstruct
    public void init() {
        movieController = DefaultSessionManager
                .getInstance()
                .getCurrentMovieController();

        final MovieData movieDataForInfo = getMovieController().getMovieDataInContext();

        if (movieDataForInfo == null
                || movieDataForInfo.getId() == -100)
            FacesUtil.redirect(FacesUtil.INDEX_URI);
    }


    public MovieController getMovieController() {
        return movieController;
    }

    public void setMovieController(MovieController movieController) {
        this.movieController = movieController;
    }
}
