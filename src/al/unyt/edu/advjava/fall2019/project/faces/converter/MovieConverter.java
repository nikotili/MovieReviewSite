package al.unyt.edu.advjava.fall2019.project.faces.converter;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.bean.FacesUtil;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import java.util.Collection;
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
                .build();
    }


    public static MovieData toDataForAdd() {
        return toDataForManage(-1);
    }

    public static MovieData toDataForEdit(int movieID) {
        return toDataForManage(movieID);
    }

    private static MovieData toDataForManage(int movieID) {
        Movie movie = DefaultAppController.getInstance().getMovieByPK(movieID);

        return new MovieData.Builder(movie.getId(), movie.getTitle())
                .setReleaseDate(movie.getReleaseDate())
                .setSynopsis(movie.getSynopsis())
                .setGenre(movie.getGenre())
                .setRating(movie.getRating())
                .build();
    }


    public static Movie toMovieFromData(MovieData movieData) {
        Movie movie = new Movie();
        movie.setId(movieData.getID());
        movie.setTitle(movieData.getTitle());
        movie.setReleaseDate(FacesUtil.toSqlDate(movieData.getReleaseDate()));
        movie.setSynopsis(movieData.getSynopsis());
        movie.setGenre(movieData.getGenre());
        movie.setRating(movieData.getRating());
        return movie;
    }

}
