package al.unyt.edu.advjava.fall2019.project.faces.method;

import al.unyt.edu.advjava.fall2019.project.core.manager.session.DefaultSessionManager;
import al.unyt.edu.advjava.fall2019.project.faces.bean.FacesUtil;

/**
 * Represents a method which can be called without checking for permission explicitly
 * Use the {@link #call(A)} to call the method with permission check
 * @param <A> argument type of the method
 * @param <R> return type of the method
 */

@FunctionalInterface
public interface RequiresLoginMethod<A, R> {

    /**
     *
     * @param arg of the method
     * @return the result of the method
     * called by {@link #call(A)}
     */

    R function(A arg);


    /**
     * @param arg of the method passed to {@link #function(A)}
     * @return the result of the method
     * @throws SecurityException if there is no logged user
     */
     default R call(A arg) {
        if (DefaultSessionManager.getInstance().hasLoggedUser())
            return function(arg);
        else
            FacesUtil.redirect(FacesUtil.LOGIN_URI, FacesUtil.LOGIN_ERROR_PARAM, FacesUtil.LOGIN_ERROR_ARG);
        return null;
    }
}
