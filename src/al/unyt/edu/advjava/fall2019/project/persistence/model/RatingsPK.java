package al.unyt.edu.advjava.fall2019.project.persistence.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RatingsPK implements Serializable {
    private String movieGoerEmail;
    private int movieId;

    @Column(name = "movie_goer_email", nullable = false, length = 50)
    @Id
    public String getMovieGoerEmail() {
        return movieGoerEmail;
    }

    public void setMovieGoerEmail(String movieGoerEmail) {
        this.movieGoerEmail = movieGoerEmail;
    }

    @Column(name = "movie_id", nullable = false)
    @Id
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingsPK ratingsPK = (RatingsPK) o;
        return movieId == ratingsPK.movieId &&
                Objects.equals(movieGoerEmail, ratingsPK.movieGoerEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieGoerEmail, movieId);
    }
}
