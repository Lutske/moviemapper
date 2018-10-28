import dataModel.Movie;
import services.MovieService;

import java.util.List;

public class Main {
    static MovieService movieService;

    public static void main(String[] args) {
        movieService = new MovieService();
        List<Movie> movies = movieService.getAllMoviesAfterDateTime(4, "2018-10-29 17:30:00");
        movieService.getMovieCombinations(movies);

    }
}
