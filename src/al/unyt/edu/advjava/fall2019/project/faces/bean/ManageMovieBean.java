package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import java.util.Collection;
import java.util.Map;

public abstract class ManageMovieBean extends RequiresLoginBean {
    private int ID;
    private String title;
    private java.util.Date releaseDate;
    private String synopsis;
    private String genre;
    private String rating;
    private Collection<String> genres = DefaultAppController.getInstance().getMovieGenres();
    private Map<String, String> ratingsMap = DefaultAppController.getInstance().getMovieRatings();

    public Collection<String> getGenres() {
        return genres;
    }

    public Map<String, String> getRatingsMap() {
        return ratingsMap;
    }

    protected int getID() {
        return ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public java.util.Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(java.util.Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public abstract void saveAction();

    protected Movie getUpdatedMovie() {
        Movie movie = new Movie();
        movie.setId(getID());
        movie.setTitle(getTitle());
        movie.setReleaseDate(BeanUtil.toSqlDate(getReleaseDate()));
        movie.setSynopsis(getSynopsis());
        movie.setGenre(getGenre());
        movie.setRating(getRating());
        return movie;
    }

}
