package al.unyt.edu.advjava.fall2019.project.faces.bean;

import al.unyt.edu.advjava.fall2019.project.faces.data.MovieData;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MovieFilter {

    public static final String TOP_10_MOVIES = "top";
    public static final String RATING_RANGE = "rating";
    public static final String GENRE = "genre";
    public static final String DIRECTOR = "director";
    public static final String TITLE = "title";
    public static final String NO_FILTER = "none";


    private String selectedFilter;
    private String userInput;
    private Collection<MovieData> movieData;

    public MovieFilter(String selectedFilter, String userInput, Collection<MovieData> movieData) {
        this.setSelectedFilter(selectedFilter);
        this.setUserInput(userInput);
        this.setMovieData(movieData);
    }

    public Collection<MovieData> getFilteredMovies() {
        switch (getSelectedFilter()) {
            case TOP_10_MOVIES:
                return filterByTopTen();
            case RATING_RANGE:
                return filterByRating();
            case GENRE:
                return filterByGenre();
            case TITLE:
                return filterByTitle();
            case DIRECTOR:
                return filterByDirector();
            default:
                return getMovieData();
        }
    }
    public Collection<MovieData> filterByTitle() {
        return getMovieData().stream()
                .filter(movieData -> movieData.getTitle().toLowerCase().contains(getUserInput().toLowerCase()))
                .collect(Collectors.toList());
    }

    public Collection<MovieData> filterByGenre() {
        return getMovieData().stream()
                .filter(movieData -> movieData.getGenre().toUpperCase().contains(getUserInput().toUpperCase()))
                .collect(Collectors.toList());
    }

    public Collection<MovieData> filterByTopTen() {
        return getMovieData().stream()
                .sorted(Comparator.comparingDouble(MovieData::getAverageRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public Collection<MovieData> filterByDirector() {
        return  getMovieData().stream()
                .filter(movieData -> movieData.getDirectors().stream()
                        .map(directorData -> directorData.getName() + " " + directorData.getSurname())
                        .anyMatch(director -> director.toLowerCase().contains(getUserInput().toLowerCase()))
                ).collect(Collectors.toList());
    }

    public Collection<MovieData> filterByRating() {

        try{
            String[] rangeLimits = getUserInput().replace(" ", "").split(",");
            double rangeFloor = Double.parseDouble(rangeLimits[0]);
            double rangeCeiling = Double.parseDouble(rangeLimits[1]);

            return getMovieData()
                    .stream()
                    .filter(movieData -> movieData.getAverageRating() >= rangeFloor && movieData.getAverageRating() <= rangeCeiling)
                    .collect(Collectors.toList());
        }catch(Exception e) {
            e.printStackTrace();
            return getMovieData();
        }
    }

    public String getSelectedFilter() {
        return selectedFilter;
    }

    public void setSelectedFilter(String selectedFilter) {
        this.selectedFilter = selectedFilter;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Collection<MovieData> getMovieData() {
        return movieData;
    }

    public void setMovieData(Collection<MovieData> movieData) {
        this.movieData = movieData;
    }
}
