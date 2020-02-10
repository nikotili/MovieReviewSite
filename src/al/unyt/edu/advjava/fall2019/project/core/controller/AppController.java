package al.unyt.edu.advjava.fall2019.project.core.controller;

import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import java.util.Collection;
import java.util.Map;

public interface AppController {

    MovieGoer authenticate(String email, String password) throws SecurityException;

    Collection<Movie> getAllMovies();

    void addMovie(Movie movie);

    Collection<String> getMovieGenres();

    Map<String, String> getMovieRatings();

}