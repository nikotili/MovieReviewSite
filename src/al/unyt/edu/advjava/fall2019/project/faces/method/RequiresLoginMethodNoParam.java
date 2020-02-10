package al.unyt.edu.advjava.fall2019.project.faces.method;

import al.unyt.edu.advjava.fall2019.project.core.manager.session.DefaultSessionManager;


/**
 * Represents a method which can be called without checking for permission explicitly
 * Use the {@link #call()} to call the method with permission check
 * @param <R> return type of the method
 */

@FunctionalInterface
public interface RequiresLoginMethodNoParam<R> {


    /**
     * @return the result of the method
     * called by {@link #call()}
     */
    R function();

    /**
     * @return the result of the method
     * @throws SecurityException if there is no logged user
     */
    default R call() throws SecurityException {
        if (DefaultSessionManager.getInstance().hasLoggedUser())
            return function();
        else
            throw new SecurityException("No permission!");
    }
}
