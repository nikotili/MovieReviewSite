import al.unyt.edu.advjava.fall2019.project.db_entities.Genre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.stream.Collectors;


/***
 * Demo
 */

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movieReview-PU");
        EntityManager em =  entityManagerFactory.createEntityManager();

        System.out.println(em.createNamedQuery("Genre.findAll", Genre.class).getResultList().get(0).getMovies().stream().collect(Collectors.toList()).get(0).getName());
    }
}