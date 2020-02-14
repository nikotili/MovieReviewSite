package al.unyt.edu.advjava.fall2019.project.faces.converter;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.bean.FacesUtil;
import al.unyt.edu.advjava.fall2019.project.faces.data.DirectorData;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
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
                .build();
    }


    public static MovieData toDataForAdd() {
        return toDataForManage(-1);
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
                .build();
    }

    public static MovieData toDataForInfo(Integer movieID) {
        Movie movie = DefaultAppController.getInstance().getMovieByPK(movieID);
        if (movie == null)
            return null;
        Set<DirectorData> directorDataSet = DirectorConverter.toDataSet(movie.getDirectors());
        return new MovieData.Builder(movie.getId(), movie.getTitle())
                .setReleaseDate(movie.getReleaseDate())
                .setSynopsis(movie.getSynopsis())
                .setGenre(movie.getGenre())
                .setRating(movie.getRating())
                .setAverageRating(movie.calculateAndGetAvgRating())
                .setDirectors(directorDataSet)
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
