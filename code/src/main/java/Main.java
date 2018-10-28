import dataModel.Movie;
import services.MovieService;

import java.util.List;

public class Main {
    static MovieService movieService;

    public static void main(String[] args) {
        movieService = new MovieService();
        movieService.readMovieFromFile();
        List<Movie> movies = movieService.readMoviesFromFile();
        System.out.println(movies);
        movieService.getMovieCombinations(movies);

    }
}
