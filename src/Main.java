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

    }
}