import al.unyt.edu.advjava.fall2019.project.model.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/***
 * Demo
 */

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movieReview-PU");
        EntityManager em = entityManagerFactory.createEntityManager();

        System.out.println(em.createNamedQuery("Movie.findAll", Movie.class).getResultList().size());
    }
}