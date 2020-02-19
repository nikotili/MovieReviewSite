package al.unyt.edu.advjava.fall2019.project.persistence.dao.interfaces;

import al.unyt.edu.advjava.fall2019.project.persistence.model.Rating;
import al.unyt.edu.advjava.fall2019.project.persistence.model.RatingsPK;

public interface RatingDao extends ModelDao<Rating, RatingsPK> {
    void upsert(Rating rating);
}
