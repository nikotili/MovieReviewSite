package al.unyt.edu.advjava.fall2019.project.bean;

import al.unyt.edu.advjava.fall2019.project.core.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class IndexBean {
    private List<Movie> movieList;

    @PostConstruct
    public void init() {
        movieList = DefaultAppController
                .getInstance()
                .getAllMovies();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}