package al.unyt.edu.advjava.fall2019.project.core.interfaces;

import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import java.util.List;

public interface AppController {

    void authenticate(String email, String password) throws SecurityException;

    List<Movie> getAllMovies();



}