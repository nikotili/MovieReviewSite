package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.core.manager.session.DefaultSessionManager;
import al.unyt.edu.advjava.fall2019.project.faces.data.RatingData;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ReviewBean extends RequiresLoginBean {
    private String comment;
    private int rating;
    private MovieController movieController = DefaultSessionManager.getInstance().getCurrentMovieController();


    @Override
    public void init() {
        try {
            super.init();
            fill();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.out.println("Redirected from super.init()");
        }
    }

    private void fill() {
        String loggedUserEmail = DefaultSessionManager
                .getInstance()
                .getLoggedInUser()
                .getEmail();

        RatingData ratingData = movieController
                .getMovieDataInContext()
                .getMovieGoerRating(loggedUserEmail);

        if (ratingData != null) {
            setComment(ratingData.getComment());
            setRating(ratingData.getRating());
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public MovieController getMovieController() {
        return movieController;
    }

}
