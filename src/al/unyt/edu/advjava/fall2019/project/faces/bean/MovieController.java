package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.faces.method.RequiresLoginMethod;
import al.unyt.edu.advjava.fall2019.project.faces.method.RequiresLoginMethodNoParam;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collection;
import java.util.Map;

@ManagedBean
@SessionScoped
public class MovieController {
    private Collection<MovieData> movieList;
    private MovieData movieDataInContext = new MovieData();
    private RequiresLoginMethodNoParam<String> addNewMovieMethod = () -> redirectTo(FacesUtil.ADD_MOVIE_URI);
    private RequiresLoginMethod<Integer, String> editMovieMethod = this::editMovie;
    private Collection<String> genres = DefaultAppController.getInstance().getMovieGenres();
    private Map<String, String> ratingsMap = DefaultAppController.getInstance().getMovieRatings();

    private boolean editMode = false;

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

    public Collection<MovieData> getMovieList() {
        return movieList;
    }

    public MovieData getMovieDataInContext() {
        return movieDataInContext;
    }

    public void setMovieDataInContext(MovieData movieDataInContext) {
        this.movieDataInContext = movieDataInContext;
    }

    public RequiresLoginMethodNoParam<String> getAddNewMovieMethod() {
        return addNewMovieMethod;
    }

    public RequiresLoginMethod<Integer, String> getEditMovieMethod() {
        return editMovieMethod;
    }

    public String displayInfoForMovie(Integer movieID) {
        movieDataInContext = MovieConverter.toDataForInfo(movieID);
        editMode = false;
        return redirectTo(FacesUtil.MOVIES_URI);
    }

    private String editMovie(Integer movieID) {
        movieDataInContext = MovieConverter.toDataForEdit(movieID);
        editMode = true;
        return redirectTo(FacesUtil.EDIT_MOVIE_URI);
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    private String redirectTo(String url) {
        FacesUtil.redirect(url);
        return null;
    }

    public String filter() {
        loadData();
        this.movieList = new MovieFilter(getSelectedFilterType(), getFilterUserInput(), getMovieList()).getFilteredMovies();
        return FacesUtil.INDEX_URI;
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
        if (movieDataInContext.getId() != -100) {
            DefaultAppController
                    .getInstance()
                    .updateMovie(MovieConverter.toMovieFromData(movieDataInContext));
        }
        reset();
        FacesUtil.redirect(FacesUtil.INDEX_URI);
    }

    public void saveAction() {
        DefaultAppController
                .getInstance()
                .addNewMovie(MovieConverter.toMovieFromData(movieDataInContext));
        reset();
        FacesUtil.redirect(FacesUtil.INDEX_URI);
    }

    private void reset() {
        movieDataInContext = new MovieData();
        movieList = MovieConverter.allMoviesToDataForIndex();
        editMode = false;
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