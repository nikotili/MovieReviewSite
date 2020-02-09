package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.faces.bean.ManagedBean;
import java.sql.Date;

//fixme error when logout from here

@ManagedBean
public class AddMovieBean {
    private String title;
    private Date releaseDate;
    private String synopsis;
    private String genre;
    private String rating;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
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

//fixme not safe
    public void addMovie() {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setReleaseDate(releaseDate);
        movie.setSynopsis(synopsis);
        movie.setGenre(genre);
        movie.setRating(rating);
        DefaultAppController.getInstance().addMovie(movie);
        BeanUtil.redirect(BeanUtil.INDEX_URI);
    }

    private void resetFields() {

    }
}
