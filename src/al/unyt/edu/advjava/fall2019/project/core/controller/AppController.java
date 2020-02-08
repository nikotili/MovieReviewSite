package al.unyt.edu.advjava.fall2019.project.core.controller;

import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

import java.util.List;

public interface AppController {

    MovieGoer authenticate(String email, String password) throws SecurityException;

    List<Movie> getAllMovies();

}