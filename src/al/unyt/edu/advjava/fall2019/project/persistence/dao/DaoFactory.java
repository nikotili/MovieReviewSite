package al.unyt.edu.advjava.fall2019.project.persistence.dao;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.MovieDao;
import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.MovieGoerDao;

public final class DaoFactory {
    private static final MovieGoerDao MOVIE_GOER_DAO;
    private static final MovieDao MOVIE_DAO;

    static {
        MOVIE_GOER_DAO = new MovieGoerDaoImpl();
        MOVIE_DAO = new MovieDaoImpl();
    }

    private DaoFactory() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static MovieGoerDao getMovieGoerDao() {
        return MOVIE_GOER_DAO;
    }

    public static MovieDao getMovieDao() {
        return MOVIE_DAO;
    }
}
