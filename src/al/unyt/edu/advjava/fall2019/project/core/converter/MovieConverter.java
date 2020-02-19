package al.unyt.edu.advjava.fall2019.project.core.converter;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.bean.FacesUtil;
import al.unyt.edu.advjava.fall2019.project.faces.data.DirectorData;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.faces.data.RatingData;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieConverter {


    public static Collection<MovieData> allMoviesToDataForIndex() {
        return toDataForIndex(DefaultAppController.getInstance().getAllMovies());
    }

    private static Collection<MovieData> toDataForIndex(Collection<Movie> movies) {
        return movies.stream()
                .map(MovieConverter::toDataForIndex)
                .collect(Collectors.toList());
    }

    private static MovieData toDataForIndex(Movie movie) {
        return new MovieData.Builder(movie.getId(), movie.getTitle())
                .setAverageRating(movie.calculateAndGetAvgRating())
                .setThumbnailLink(movie.getThumbnailLink())
                .build();
    }

    public static MovieData toDataForEdit(Integer movieID) {
        return toDataForManage(movieID);
    }

    private static MovieData toDataForManage(Integer movieID) {
        Movie movie = DefaultAppController.getInstance().getMovieByPK(movieID);
        if (movie == null)
            return null;
        return new MovieData.Builder(movie.getId(), movie.getTitle())
                .setReleaseDate(movie.getReleaseDate())
                .setSynopsis(movie.getSynopsis())
                .setGenre(movie.getGenre())
                .setRating(movie.getRating())
                .setThumbnailLink(movie.getThumbnailLink())
                .build();
    }

    public static MovieData toDataForRating(Movie movie) {
        if (movie == null)
            return null;

        return new MovieData.Builder(movie.getId(), movie.getTitle()).build();
    }

    public static MovieData toDataForReview(Integer movieID) {
        Movie movie = DefaultAppController.getInstance().getMovieByPK(movieID);
        if (movie == null)
            return null;
        Set<RatingData> ratingDataList = RatingConverter.toDataSet(movie.getRatings());

        return new MovieData
                .Builder(movie.getId(), movie.getTitle()).setRatingData(ratingDataList)
                .build();
    }

    public static MovieData toDataForInfo(Integer movieID) {
        Movie movie = DefaultAppController.getInstance().getMovieByPK(movieID);
        if (movie == null)
            return null;
        Set<DirectorData> directorDataSet = DirectorConverter.toDataSet(movie.getDirectors());
        Set<RatingData> ratingDataList = RatingConverter.toDataSet(movie.getRatings());
        return new MovieData.Builder(movie.getId(), movie.getTitle())
                .setReleaseDate(movie.getReleaseDate())
                .setSynopsis(movie.getSynopsis())
                .setGenre(movie.getGenre())
                .setRating(movie.getRating())
                .setThumbnailLink(movie.getThumbnailLink())
                .setAverageRating(movie.calculateAndGetAvgRating())
                .setDirectors(directorDataSet)
                .setRatingData(ratingDataList)
                .build();
    }


    public static Movie toMovieFromData(MovieData movieData) {
        Movie movie = new Movie();
        movie.setId(movieData.getId());
        movie.setTitle(movieData.getTitle());
        movie.setReleaseDate(FacesUtil.toSqlDate(movieData.getReleaseDate()));
        movie.setSynopsis(movieData.getSynopsis());
        movie.setGenre(movieData.getGenre());
        movie.setRating(movieData.getRating());
        movie.setThumbnailLink(movieData.getThumbnailLink());
        return movie;
    }

}
