package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.core.manager.session.DefaultSessionManager;
import al.unyt.edu.advjava.fall2019.project.faces.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceException;
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
        try {
            String idString = FacesUtil.getRequestParameterValue(FacesUtil.MOVIE_ID_PARAM);

            Integer id = Integer.valueOf(idString);
            MovieData movieData = MovieConverter.toDataForEdit(id);
            loadMovieToUpdate(movieData);
        }
        catch (NullPointerException e) {
            System.out.println("EditMovieBean.tryFill" + e.toString());
        }
        catch (NumberFormatException | PersistenceException e) {
//            FacesUtil.redirect(FacesUtil.INDEX_URI);
        }
    }

    private void loadMovieToUpdate(MovieData movie) {
        setId(movie.getID());
        setTitle(movie.getTitle());
        setReleaseDate(movie.getReleaseDate());
        setSynopsis(movie.getSynopsis());
        setGenre(movie.getGenre());
        setRating(movie.getRating());
    }


    @Override
    public void saveAction() {
        final MovieData movieData = getMovieData();
        DefaultAppController
                .getInstance()
                .updateMovie(MovieConverter.toMovieFromData(movieData));
//        reset();
        FacesUtil.redirect(FacesUtil.INDEX_URI);
    }


    //fixme: there should be another way...
    private void reset() {
        DefaultSessionManager.getInstance().removeObjectFromSession("editMovieBean");
    }

}
