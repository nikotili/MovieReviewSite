package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.faces.method.RequiresLoginMethod;
import al.unyt.edu.advjava.fall2019.project.faces.method.RequiresLoginMethodNoParam;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collection;
import java.util.Map;

@ManagedBean
@SessionScoped
public class MovieController {
    private Collection<MovieData> movieList;
    private MovieData movieDataForInfo = MovieData.DUMMY;
    private MovieData movieDataForEdit = new MovieData();
    private Movie movieInContext = new Movie();
    private RequiresLoginMethodNoParam<String> addNewMovieMethod = () -> redirectTo(FacesUtil.ADD_MOVIE_URI);
    private RequiresLoginMethod<Integer, String> editMovieMethod = this::editMovie;
    private Collection<String> genres = DefaultAppController.getInstance().getMovieGenres();
    private Map<String, String> ratingsMap = DefaultAppController.getInstance().getMovieRatings();

    private String selectedFilterType = MovieFilter.NO_FILTER;
    private String filterUserInput = "";

    @PostConstruct
    public void init() {
        loadData();
    }

    private void loadData() {
        movieList = MovieConverter.allMoviesToDataForIndex();
    }

    public Collection<String> getGenres() {
        return genres;
    }

    public void setGenres(Collection<String> genres) {
        this.genres = genres;
    }

    public Map<String, String> getRatingsMap() {
        return ratingsMap;
    }

    public void setRatingsMap(Map<String, String> ratingsMap) {
        this.ratingsMap = ratingsMap;
    }

    public MovieData getMovieDataForInfo() {
        return movieDataForInfo;
    }

    public void setMovieDataForInfo(MovieData movieDataForInfo) {
        this.movieDataForInfo = movieDataForInfo;
    }

    public MovieData getMovieDataForEdit() {
        return movieDataForEdit;
    }

    public void setMovieDataForEdit(MovieData movieDataForEdit) {
        this.movieDataForEdit = movieDataForEdit;
    }

    public Collection<MovieData> getMovieList() {
        return movieList;
    }

    public RequiresLoginMethodNoParam<String> getAddNewMovieMethod() {
        return addNewMovieMethod;
    }

    public RequiresLoginMethod<Integer, String> getEditMovieMethod() {
        return editMovieMethod;
    }

    public void setEditMovieMethod(RequiresLoginMethod<Integer, String> editMovieMethod) {
        this.editMovieMethod = editMovieMethod;
    }

    public Movie getMovieInContext() {
        return movieInContext;
    }

    public void setMovieInContext(Movie movieInContext) {
        this.movieInContext = movieInContext;
    }

    public String displayInfoForMovie(Integer movieID) {
        movieInContext = DefaultAppController.getInstance().getMovieByPK(movieID);
        movieDataForInfo = MovieConverter.toDataForInfo(movieID);
        return FacesUtil.MOVIES_URI;
    }

    private String editMovie(Integer movieID) {
        movieInContext = DefaultAppController.getInstance().getMovieByPK(movieID);
        movieDataForEdit = MovieConverter.toDataForEdit(movieID);
        return FacesUtil.EDIT_MOVIE_URI;
    }

    private String redirectTo(String url) {
        FacesUtil.redirect(url);
        return null;
    }

    public String getMovieInfoURL(int movieID) {
        return FacesUtil.buildMovieInfoURL(movieID);
    }

    public String filter() {
        loadData();
        this.movieList = new MovieFilter(getSelectedFilterType(), getFilterUserInput(), getMovieList()).getFilteredMovies();
        return "index.html";
    }

    public String getFilterUserInput() {
        return filterUserInput;
    }

    public void setFilterUserInput(String filterUserInput) {
        this.filterUserInput = filterUserInput;
    }

    public String getSelectedFilterType() {
        return selectedFilterType;
    }

    public void setSelectedFilterType(String selectedFilterType) {
        this.selectedFilterType = selectedFilterType;
    }

    public void saveEdit() {
        final MovieData movieData = movieDataForEdit;
        if (movieDataForEdit.getId() != -100) {
            DefaultAppController
                    .getInstance()
                    .updateMovie(MovieConverter.toMovieFromData(movieData));
        }
        movieDataForEdit = new MovieData();
        movieInContext = new Movie();
        movieList = MovieConverter.allMoviesToDataForIndex();
        FacesUtil.redirect(FacesUtil.INDEX_URI);
    }

    public String getTop10FilterValue() {
        return MovieFilter.TOP_10_MOVIES;
    }

    public String getRatingRangeFilterValue() {
        return MovieFilter.RATING_RANGE;
    }

    public String getGenreFilterValue() {
        return MovieFilter.GENRE;
    }

    public String getDirectorFilterValue() {
        return MovieFilter.DIRECTOR;
    }

    public String getTitleFilterValue() {
        return MovieFilter.TITLE;
    }

    public String getNoFilterValue() {
        return MovieFilter.NO_FILTER;
    }
}