package al.unyt.edu.advjava.fall2019.project.persistence.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movies_directors_relations", schema = "movie_review")
@IdClass(MoviesDirectorsRelationsPK.class)
public class MoviesDirectorsRelations {
    private int movieId;
    private int directorId;

    @Id
    @Column(name = "movie_id", nullable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Id
    @Column(name = "director_id", nullable = false)
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
        MoviesDirectorsRelations that = (MoviesDirectorsRelations) o;
        return movieId == that.movieId &&
                directorId == that.directorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, directorId);
    }
}
