package al.unyt.edu.advjava.fall2019.project.core.converter;

import al.unyt.edu.advjava.fall2019.project.faces.data.MovieGoerData;
import al.unyt.edu.advjava.fall2019.project.persistence.model.MovieGoer;

public class MovieGoerConverter {

    public static MovieGoerData toData(MovieGoer movieGoer) {
        if (movieGoer == null)
            return null;

        return new MovieGoerData(movieGoer.getName(), movieGoer.getSurname(), movieGoer.getEmail());
    }
}
