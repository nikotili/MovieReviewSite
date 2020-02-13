package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.faces.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class AddMovieBean extends ManageMovieBean {

    @Override
    public void saveAction() {
        final MovieData movieData = getMovieData();
        DefaultAppController
                .getInstance()
                .addNewMovie(MovieConverter.toMovieFromData(movieData));
        FacesUtil.redirect(FacesUtil.INDEX_URI);
    }
}
