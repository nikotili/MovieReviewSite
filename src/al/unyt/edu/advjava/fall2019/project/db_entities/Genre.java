package al.unyt.edu.advjava.fall2019.project.db_entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Genre.findAll", query = "SELECT g FROM Genre g")
})
@Entity
@Table(name = "genres", schema = "movie_review", catalog = "")
public class Genre {
    private int id;
    private String name;
    private Set<Movie> movies;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "genres")
    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id &&
                Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
