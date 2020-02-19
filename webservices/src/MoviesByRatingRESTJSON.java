import al.unyt.edu.advjava.fall2019.project.core.controller.DefaultAppController;
import al.unyt.edu.advjava.fall2019.project.core.converter.MovieConverter;
import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;
import al.unyt.edu.advjava.fall2019.project.persistence.PersistenceUtil;
import com.google.gson.Gson;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Path("moviesByRating")
public class MoviesByRatingRESTJSON {

    private Supplier<EntityManager> entityManagerSupplier = PersistenceUtil::newDefaultEntityManager;
    private Map<String, String> ratingsMap = DefaultAppController.getInstance().getMovieRatings();

    public MoviesByRatingRESTJSON() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{rating:.*}")
    public String getRest(@PathParam("rating") String rating) {
        Collection<MovieData> movies = new ArrayList<>();
        EntityManager em = entityManagerSupplier.get();
        try {
            movies = MovieConverter.allMoviesToDataForREST();

            if(rating != null && !rating.equals("")) {
                List<String> remainingUrl = Arrays.asList(rating.split("/"));
                String ratingKey = remainingUrl.get(0);

                String ratingVal = ratingsMap.get(ratingKey);

                movies = movies.stream()
                        .filter(m -> m.getRating().equalsIgnoreCase(ratingVal))
                        .collect(Collectors.toList());
            }
        } catch (NoResultException e) {
            System.out.println("No Results!");
        }

        Movies moviesList = new Movies();
        moviesList.setMovieDataList(movies);
        return new Gson().toJson(moviesList);
    }


    private static class Movies {
        private Collection<MovieData> movieDataList;

        public Collection<MovieData> getMovieDataList() {
            return movieDataList;
        }

        public void setMovieDataList(Collection<MovieData> movieDataList) {
            this.movieDataList = movieDataList;
        }
    }
}
