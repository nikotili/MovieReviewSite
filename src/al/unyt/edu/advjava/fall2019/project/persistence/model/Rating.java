package al.unyt.edu.advjava.fall2019.project.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ratings", schema = "movie_review")
@IdClass(RatingsPK.class)
public class Rating {
    private String movieGoerEmail;
    private int movieId;
    private int rating;
    private String comment;
    private Movie movie;
    private MovieGoer movieGoer;

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
    @Column(name = "comment", length = 100)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JoinColumn(
            name = "movie_id",
            referencedColumnName = "id",
            insertable = false,
            updatable = false
    )
    @ManyToOne(optional = false)
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @JoinColumn(
            name = "movie_goer_email",
            referencedColumnName = "email",
            insertable = false,
            updatable = false
    )
    @ManyToOne(optional = false)
    public MovieGoer getMovieGoer() {
        return movieGoer;
    }

    public void setMovieGoer(MovieGoer movieGoer) {
        this.movieGoer = movieGoer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return movieId == rating.movieId &&
                this.rating == rating.rating &&
                Objects.equals(movieGoerEmail, rating.movieGoerEmail) &&
                Objects.equals(comment, rating.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieGoerEmail, movieId, rating, comment);
    }
}
