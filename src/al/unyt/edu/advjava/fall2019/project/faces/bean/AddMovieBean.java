package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.faces.bean.ManagedBean;
import java.util.Collection;
import java.util.Map;


@ManagedBean
public class AddMovieBean extends RequiresLoginBean {
    private String title;
    private java.util.Date releaseDate;
    private String synopsis;
    private String genre;
    private String rating;
    private Collection<String> genres;
    private Map<String, String> ratingsMap;

    @Override
    public void init() {
        super.init();
        genres = DefaultAppController.getInstance().getMovieGenres();
        ratingsMap = DefaultAppController.getInstance().getMovieRatings();
    }

    public Collection<String> getGenres() {
        return genres;
    }

    public Map<String, String> getRatingsMap() {
        return ratingsMap;
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

    public void addMovie() {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setReleaseDate(BeanUtil.toSqlDate(releaseDate));
        movie.setSynopsis(synopsis);
        movie.setGenre(genre);
        movie.setRating(rating);
        DefaultAppController.getInstance().addMovie(movie);
        BeanUtil.redirect(BeanUtil.INDEX_URI);
    }

    private void resetFields() {

    }
}
