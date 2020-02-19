import al.unyt.edu.advjava.fall2019.project.faces.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.persistence.PersistenceUtil;
import al.unyt.edu.advjava.fall2019.project.persistence.model.Movie;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("moviesByRating")
public class MoviesByRatingRESTJSON {

    Supplier<EntityManager> entityManagerSupplier = PersistenceUtil::newDefaultEntityManager;

    public MoviesByRatingRESTJSON() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{rating:.*}")
    public String getRest(@PathParam("rating") String rating) {
        List<MovieData> movies = new ArrayList<>();
        EntityManager em = entityManagerSupplier.get();
        try {
            movies = em.createNamedQuery("Movie.findAll", Movie.class)
                    .getResultList()
                    .stream()
                    .map(m -> MovieConverter.toDataForInfo(m.getId()))
                    .collect(Collectors.toList());

            if(rating != null && !rating.equals("")) {
                List<String> remainingUrl = Arrays.asList(rating.split("/"));
                String ratingPart = remainingUrl.get(0);
                movies = movies.stream()
                        .filter(m -> m.getRating().equalsIgnoreCase(ratingPart))
                        .collect(Collectors.toList());
            }
        } catch (NoResultException e) {
            System.out.println("No Results!");
        }

        Movies moviesList = new Movies();
        moviesList.setMovieDataList(movies);
        return new Gson().toJson(moviesList);
    }


    private class Movies {
        private List<MovieData> movieDataList;

        public List<MovieData> getMovieDataList() {
            return movieDataList;
        }

        public void setMovieDataList(List<MovieData> movieDataList) {
            this.movieDataList = movieDataList;
        }
    }
}
