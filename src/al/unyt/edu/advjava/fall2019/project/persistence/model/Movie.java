package al.unyt.edu.advjava.fall2019.project.persistence.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@NamedQueries(
        @NamedQuery(name = "Movie.findAll", query = "SELECT m from Movie m")
)
@Entity
@Table(name = "movies", schema = "movie_review")
public class Movie implements Serializable {
    private int id;
    private String title;
    private Date releaseDate;
    private String synopsis;
    private String genre;
    private String rating;
    private String thumbnailLink;
    private Set<Director> directors;
    private Set<Rating> ratings;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "thumbnail_link", nullable = true, length = 1000)
    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    @Basic
    @Column(name = "release_date", nullable = false)
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "synopsis", length = 400)
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Basic
    @Column(name = "genre", nullable = false, length = 30)
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "rating", nullable = false, length = 10)
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @ManyToMany
    @JoinTable(
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

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public double calculateAndGetAvgRating() {
        return ratings
                .stream()
                .mapToInt(Rating::getRating)
                .average()
                .orElse(0.0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Objects.equals(title, movie.title) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(synopsis, movie.synopsis) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(rating, movie.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, synopsis, genre, rating);
    }
}
