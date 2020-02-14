package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.faces.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.DirectorData;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.faces.method.RequiresLoginMethodNoParam;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.Set;

@ManagedBean
@ViewScoped
public class MovieInfoBean implements Serializable {
    private MovieData movieData = MovieData.DUMMY;

    private RequiresLoginMethodNoParam<String> editMovieMethod = this::redirectToEditMovieURL;

    @PostConstruct
    public void init() {
        tryFill();
    }

    private void tryFill() {
        try {
            String idString = FacesUtil.getRequestParameterValue(FacesUtil.MOVIE_ID_PARAM);
            Integer id = Integer.valueOf(idString);
            this.movieData = MovieConverter.toDataForInfo(id);
        }
        catch (NumberFormatException | PersistenceException e) {
            FacesUtil.redirect(FacesUtil.INDEX_URI);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getID() {
        return movieData.getID();
    }

    public String getTitle()
    {
        return this.movieData.getTitle();
    }

    public void setTitle(String title) {
        this.movieData.setTitle(title);
    }

    public java.util.Date getReleaseDate() {
        return this.movieData.getReleaseDate();
    }

    public void setReleaseDate(java.util.Date releaseDate) {
        this.movieData.setReleaseDate(releaseDate);
    }

    public String getSynopsis() {
        return this.movieData.getSynopsis();
    }

    public void setSynopsis(String synopsis) {
        this.movieData.setSynopsis(synopsis);
    }

    public String getGenre() {
        return this.movieData.getGenre();
    }

    public void setGenre(String genre) {
        this.movieData.setGenre(genre);
    }

    public String getRating() {
        return this.movieData.getRating();
    }

    public void setRating(String rating) {
        this.movieData.setRating(rating);
    }

    public double getAverageRating() {
        return movieData.getAverageRating();
    }

    public Set<DirectorData> getDirectors() {
        return movieData.getDirectors();
    }

    public String getEditMovieURL() {
        return FacesUtil.buildEditMovieURL(movieData.getID());
    }

    private String redirectToEditMovieURL(){
        return redirectTo(getEditMovieURL());
    }

    private String redirectTo(String url) {
        FacesUtil.redirect(url);
        return null;
    }


    public RequiresLoginMethodNoParam<String> getEditMovieMethod() {
        return editMovieMethod;
    }

    public void setEditMovieMethod(RequiresLoginMethodNoParam<String> editMovieMethod) {
        this.editMovieMethod = editMovieMethod;
    }
}
