package al.unyt.edu.advjava.fall2019.project.persistence.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MoviesDirectorsRelationsPK implements Serializable {
    private int movieId;
    private int directorId;

    @Column(name = "movie_id", nullable = false)
    @Id
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Column(name = "director_id", nullable = false)
    @Id
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviesDirectorsRelationsPK that = (MoviesDirectorsRelationsPK) o;
        return movieId == that.movieId &&
                directorId == that.directorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, directorId);
    }
}
