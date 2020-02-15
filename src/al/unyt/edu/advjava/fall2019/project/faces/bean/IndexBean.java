package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.faces.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.faces.method.RequiresLoginMethodNoParam;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Collection;

@ManagedBean
@RequestScoped
public class IndexBean {
    private Collection<MovieData> movieList;
    private RequiresLoginMethodNoParam<String> addNewMovieMethod = () -> redirectTo(FacesUtil.ADD_MOVIE_URI);

    private String filterType = "none";
    private String filterValue = "";

    @PostConstruct
    public void init() {
        movieList = MovieConverter.allMoviesToDataForIndex();
    }

    public Collection<MovieData> getMovieList() {
        return movieList;
    }

    public RequiresLoginMethodNoParam<String> getAddNewMovieMethod() {
        return addNewMovieMethod;
    }

    private String redirectTo(String url) {
        FacesUtil.redirect(url);
        return null;
    }

    public String getMovieInfoURL(int movieID) {
        return FacesUtil.buildMovieInfoURL(movieID);
    }

    public String filter() {
    //todo
        return "index.html";
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }
}