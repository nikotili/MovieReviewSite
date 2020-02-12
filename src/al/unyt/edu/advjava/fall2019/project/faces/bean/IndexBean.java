package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.method.RequiresLoginMethodNoParam;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Collection;

@ManagedBean
@RequestScoped
public class IndexBean {
    private Collection<Movie> movieList;
    private RequiresLoginMethodNoParam<String> addNewMovieMethod = () -> redirectTo(BeanUtil.ADD_MOVIE_URI);
    private RequiresLoginMethodNoParam<String> editMovieMethod = () -> redirectTo(BeanUtil.EDIT_MOVIE_URI);


    @PostConstruct
    public void init() {
        movieList = DefaultAppController
                .getInstance()
                .getAllMovies();
    }

    public Collection<Movie> getMovieList() {
        return movieList;
    }

    public RequiresLoginMethodNoParam<String> getAddNewMovieMethod() {
        return addNewMovieMethod;
    }

    private String redirectTo(String url) {
        BeanUtil.redirect(url);
        return null;
    }

    public String getMovieInfoURL(int movieID) {
        return BeanUtil.buildMovieInfoURL(movieID);
    }
}