package al.unyt.edu.advjava.fall2019.project.faces.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MovieData {
    public static final MovieData DUMMY = new MovieData();
    private Integer id = -100;
    private String title;
    private Date releaseDate;
    private String synopsis;
    private String genre;
    private String rating;
    private Set<DirectorData> directors;
    private Set<RatingData> ratingData;
    private double averageRating;
    private String thumbnailLink;

    public Integer getId() {
        return id;
    }

    public static class Builder {
        private Integer id;
        private String title;
        private Date releaseDate = null;
        private String synopsis = "";
        private String genre = "";
        private String rating = "";
        private Set<DirectorData> directors = new HashSet<>();
        private Set<RatingData> ratingData = new HashSet<>();
        double averageRating = 0.0D;
        private String thumbnailLink = "";

        public Builder(Integer id, String title) {
            this.id = id;
            this.title = title;
        }

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setReleaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setSynopsis(String synopsis) {
            this.synopsis = synopsis;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setRating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder setDirectors(Set<DirectorData> directors) {
            this.directors = directors;
            return this;
        }

        public Builder setAverageRating(double averageRating) {
            this.averageRating = averageRating;
            return this;
        }

        public Builder setRatingData(Set<RatingData> ratingData) {
            this.ratingData = ratingData;
            return this;
        }

        public Builder setThumbnailLink(String thumbnailLink) {
            this.thumbnailLink = thumbnailLink;
            return this;
        }

        public MovieData build() {
            return new MovieData(id, title, releaseDate, synopsis, genre, rating, directors, ratingData, averageRating, thumbnailLink);
        }
    }

    private MovieData(Integer id, String title, Date releaseDate, String synopsis, String genre, String rating,
                      Set<DirectorData> directors, Set<RatingData> ratingData,
                      double averageRating, String thumbnailLink) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.genre = genre;
        this.rating = rating;
        this.directors = directors;
        this.ratingData = ratingData;
        this.averageRating = averageRating;
        this.thumbnailLink = thumbnailLink;
    }

    public MovieData(){}

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Set<DirectorData> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<DirectorData> directors) {
        this.directors = directors;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public Set<RatingData> getRatingData() {
        return ratingData;
    }

    public void setRatingData(Set<RatingData> ratingData) {
        this.ratingData = ratingData;
    }

    public RatingData getMovieGoerRating(String email) {
        return this.getRatingData()
                .stream()
                .filter(ratingData -> ratingData
                        .getMovieGoerData()
                        .getEmail()
                        .equals(email))
                .findAny()
                .orElse(null);
    }

    public String getThumbnailLink() {
        if(thumbnailLink == null){
            return "";
        }
        return thumbnailLink;
    }

    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    public String getDirectorNameList() {
        return directors
                .toString()
                .replace("[", "")
                .replace("]", "");
    }
}
