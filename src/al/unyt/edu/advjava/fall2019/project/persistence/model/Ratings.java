package al.unyt.edu.advjava.fall2019.project.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(RatingsPK.class)
public class Ratings {
    private String movieGoerEmail;
    private int movieId;
    private int rating;
    private String comment;

    @Id
    @Column(name = "movie_goer_email", nullable = false, length = 50)
    public String getMovieGoerEmail() {
        return movieGoerEmail;
    }

    public void setMovieGoerEmail(String movieGoerEmail) {
        this.movieGoerEmail = movieGoerEmail;
    }

    @Id
    @Column(name = "movie_id", nullable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 100)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ratings ratings = (Ratings) o;
        return movieId == ratings.movieId &&
                rating == ratings.rating &&
                Objects.equals(movieGoerEmail, ratings.movieGoerEmail) &&
                Objects.equals(comment, ratings.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieGoerEmail, movieId, rating, comment);
    }
}
