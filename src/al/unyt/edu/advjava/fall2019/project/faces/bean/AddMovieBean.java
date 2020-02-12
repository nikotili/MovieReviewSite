package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class AddMovieBean extends ManageMovieBean {



    @Override
    public void saveAction() {
        final Movie movie = getUpdatedMovie();
        DefaultAppController.getInstance().addMovie(movie);
        BeanUtil.redirect(BeanUtil.INDEX_URI);
    }}
