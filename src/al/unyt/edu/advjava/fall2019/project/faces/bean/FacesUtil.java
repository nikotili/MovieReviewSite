package al.unyt.edu.advjava.fall2019.project.faces.bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FacesUtil {

    public static final String INDEX_URI = "index.xhtml";
    public static final String LOGIN_URI = "login.xhtml";
    public static final String ADD_MOVIE_URI = "add-movie.xhtml";
    public static final String EDIT_MOVIE_URI = "edit-movie.xhtml";
    public static final String REVIEW_MOVIE_URI = "review.xhtml";
    public static final String MOVIES_URI = "movies.xhtml";
    public static final String MOVIE_ID_PARAM = "id";
    public static final String LOGIN_ERROR_PARAM = "loginerr";
    public static final String LOGIN_ERROR_ARG = "loginerr";
    public static final String MOVIE_URI_WITH_PARAM = MOVIES_URI + '?' + MOVIE_ID_PARAM + '=';
    public static final String EDIT_MOVIE_URI_WITH_PARAM = EDIT_MOVIE_URI + '?' + MOVIE_ID_PARAM + '=';


    private FacesUtil() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void redirect(String url, String argumentName, String argumentValue) {
        String urlArguments = "?faces-redirect=true";
        if(argumentName != null && argumentValue != null) {
            urlArguments += "&" + argumentName + "=" + argumentValue;
        }
        try {
            getFacesExternalContext()
                    .redirect(url + urlArguments);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void redirect(String url) {
        System.out.println("URL" + url);
        redirect(url, null, null);
    }

    public static java.sql.Date toSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static String buildMovieInfoURL(int movieID) {
        return MOVIE_URI_WITH_PARAM + movieID;
    }

    public static String buildEditMovieURL(int movieID) {
        return EDIT_MOVIE_URI_WITH_PARAM + movieID;
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

    public static String getRequestParameterValue(String param) {
        return getCurrentRequest().getParameter(param);
    }
}
