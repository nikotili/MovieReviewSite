package al.unyt.edu.advjava.fall2019.project.persistence.dao;

import al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces.RatingDao;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Rating;
import al.unyt.edu.advjava.fall2019.project.persistence.model.RatingsPK;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.Collection;

public class RatingDaoImpl implements RatingDao {
    @Override
    public Collection<Rating> getAll() throws PersistenceException {
        return entityManagerSupplier
                .get().createNamedQuery("Rating.findAll", Rating.class)
                .getResultList();
    }

    @Override
    public void delete(Rating rating) throws PersistenceException {

    }

    @Override
    public Collection<Rating> getByColumnName(String columnName, String value) throws PersistenceException {
        return null;
    }

    @Override
    public void upsert(Rating rating) {
        EntityManager entityManager = entityManagerSupplier.get();
        RatingsPK ratingsPK = new RatingsPK();
        ratingsPK.setMovieId(rating.getMovieId());
        ratingsPK.setMovieGoerEmail(rating.getMovieGoerEmail());
        if (entityManager.find(Rating.class, ratingsPK) != null)
            update(rating);
        else
            persist(rating);
    }
}
