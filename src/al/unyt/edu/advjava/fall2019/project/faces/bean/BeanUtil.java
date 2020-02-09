package al.unyt.edu.advjava.fall2019.project.faces.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class BeanUtil {

    public static String INDEX_URI = "index.xhtml";
    public static String LOGIN_URI = "login.xhtml";
    public static String ADD_MOVIE_URI = "WEB-INF/add-movie.xhtml";


    private BeanUtil() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void redirect(String url) {
        try {
            getFacesContextInstance()
                    .getExternalContext()
                    .redirect(url);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayMessage(String componentID, String message) {
        getFacesContextInstance()
                .addMessage(componentID, new FacesMessage(message));
    }

    private static FacesContext getFacesContextInstance() {
        return FacesContext.getCurrentInstance();
    }
}
