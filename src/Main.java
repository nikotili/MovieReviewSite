import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;

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


        System.out.println(em.find(Movie.class, 1).getRatings().get(0).getComment());
    }
}