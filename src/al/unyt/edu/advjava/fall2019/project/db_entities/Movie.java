package al.unyt.edu.advjava.fall2019.project.db_entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m")
        })
@Entity
@Table(name = "movies", schema = "movie_review")
public class Movie {
    private int id;
    private String name;
    private String description;
    private Set<Genre> genres;
    private Set<Director> directors;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 400)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @ManyToMany
    @JoinTable (
           name = "movies_genres_relations",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @ManyToMany
    @JoinTable (
            name = "movies_directors_relations",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Objects.equals(name, movie.name) &&
                Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
