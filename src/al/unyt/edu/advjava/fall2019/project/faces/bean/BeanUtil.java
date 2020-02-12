package al.unyt.edu.advjava.fall2019.project.faces.bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BeanUtil {

    public static final String INDEX_URI = "index.xhtml";
    public static final String LOGIN_URI = "login.xhtml";
    public static final String ADD_MOVIE_URI = "add-movie.xhtml";
    public static final String EDIT_MOVIE_URI = "edit-movie.xhtml";
    public static final String MOVIES_URI = "movies.xhtml";
    public static final String MOVIE_ID_PARAM = "id";
    public static final String MOVIE_URI_WITH_PARAM = MOVIES_URI + '?' + MOVIE_ID_PARAM + '=';


    private BeanUtil() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void redirect(String url) {
        try {
            getFacesExternalContext()
                    .redirect(url + "?faces-redirect=true");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void displayMessage(String componentID, String message) {
//        getFacesContextInstance()
//                .addMessage(componentID, new FacesMessage(message));
//    }

    public static java.sql.Date toSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static String buildMovieInfoURL(int movieID) {
        return MOVIE_URI_WITH_PARAM + movieID;
    }

    private static FacesContext getFacesContextInstance() {
        return FacesContext.getCurrentInstance();
    }

    private static ExternalContext getFacesExternalContext() {
        return getFacesContextInstance().getExternalContext();
    }

    public static HttpServletRequest getCurrentRequest() {
        return (HttpServletRequest) getFacesExternalContext().getRequest();
    }

    public static void removeFromSession(String key) {
        getFacesExternalContext().getSessionMap().remove(key);
    }

    public static String getRequestParameterValue(String param) {
        return getCurrentRequest().getParameter(param);
    }
}
