package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;

import java.util.Collection;
import java.util.Map;
@Deprecated
public abstract class ManageMovieBean extends RequiresLoginBean {

    private MovieData movieData = MovieData.DUMMY;
    private Collection<String> genres = DefaultAppController.getInstance().getMovieGenres();
    private Map<String, String> ratingsMap = DefaultAppController.getInstance().getMovieRatings();

    public Collection<String> getGenres() {
        return genres;
    }

    public Map<String, String> getRatingsMap() {
        return ratingsMap;
    }

    public Integer getId() {
        return this.movieData.getId();
    }

    public void setId(Integer ID) {
        this.movieData.setId(ID);
    }

    public String getTitle()
    {
        return this.movieData.getTitle();
    }

    public void setTitle(String title) {
        this.movieData.setTitle(title);
    }

    public java.util.Date getReleaseDate() {
        return this.movieData.getReleaseDate();
    }

    public void setReleaseDate(java.util.Date releaseDate) {
        this.movieData.setReleaseDate(releaseDate);
    }

    public String getSynopsis() {
        return this.movieData.getSynopsis();
    }

    public void setSynopsis(String synopsis) {
        this.movieData.setSynopsis(synopsis);
    }

    public String getGenre() {
        return this.movieData.getGenre();
    }

    public void setGenre(String genre) {
        this.movieData.setGenre(genre);
    }

    public String getRating() {
        return this.movieData.getRating();
    }

    public void setRating(String rating) {
        this.movieData.setRating(rating);
    }

    public abstract void saveAction();

    protected MovieData getMovieData() {
        return this.movieData;
    }

}
