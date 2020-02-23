package al.unyt.edu.advjava.fall2019.project.faces.data;

public class RatingData {

    private MovieGoerData movieGoerData;
    private transient MovieData movieData;
    private String comment;
    private int rating;

    public RatingData(MovieGoerData movieGoerData, MovieData movieData, String comment, int rating) {
        this.movieGoerData = movieGoerData;
        this.movieData = movieData;
        this.comment = comment;
        this.rating = rating;
    }

    public MovieGoerData getMovieGoerData() {
        return movieGoerData;
    }

    public MovieData getMovieData() {
        return movieData;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
