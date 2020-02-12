package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class EditMovieBean extends ManageMovieBean implements Serializable {

    @Override
    public void init() {
        super.init();
        tryFill();
    }

    private void tryFill() {
        String idString = BeanUtil.getRequestParameterValue(BeanUtil.MOVIE_ID_PARAM);

        try {
            Integer id = Integer.valueOf(idString);
            Movie movie = DefaultAppController.getInstance().getMovieByPK(id);
            loadMovieToUpdate(movie);
        }
        catch (NumberFormatException e) {
            BeanUtil.redirect(BeanUtil.INDEX_URI);
        }
    }

    private void loadMovieToUpdate(Movie movie) {
        setID(movie.getId());
        setTitle(movie.getTitle());
        setReleaseDate(movie.getReleaseDate());
        setSynopsis(movie.getSynopsis());
        setGenre(movie.getGenre());
        setRating(movie.getRating());
    }


    @Override
    public void saveAction() {
        final Movie movie = getUpdatedMovie();
        DefaultAppController.getInstance().updateMovie(movie);
        reset();
        BeanUtil.redirect(BeanUtil.INDEX_URI);
    }


    //fixme: there should be another way...
    private void reset() {
        BeanUtil.removeFromSession("editMovieBean");
    }

}
