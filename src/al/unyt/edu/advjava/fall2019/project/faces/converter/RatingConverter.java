package al.unyt.edu.advjava.fall2019.project.faces.converter;

import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieGoerData;
import al.unyt.edu.advjava.fall2019.project.faces.data.RatingData;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Rating;

import java.util.List;
import java.util.stream.Collectors;

public class RatingConverter {

    public static RatingData toData(Rating rating) {
        MovieGoerData movieGoerData = MovieGoerConverter.toData(rating.getMovieGoer());
        MovieData movieData = MovieConverter.toDataForRating(rating.getMovie());

        return new RatingData(movieGoerData, movieData, rating.getComment(), rating.getRating());
    }

    public static List<RatingData> toDataList(List<Rating> ratings) {
        return ratings
                .stream()
                .map(RatingConverter::toData)
                .collect(Collectors.toList());
    }

    public static Rating toRating(RatingData ratingData) {
        Rating rating = new Rating();
        rating.setComment(ratingData.getComment());
        rating.setMovieGoerEmail(ratingData.getMovieGoerData().getEmail());
        rating.setMovieId(ratingData.getMovieData().getId());
        rating.setRating(ratingData.getRating());

        return rating;
    }

}
