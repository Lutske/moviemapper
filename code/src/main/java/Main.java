import dataModel.Movie;
import dataModel.MovieCombination;
import enums.Genre;
import services.MovieService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static MovieService movieService;

    public static void main(String[] args) {
        movieService = new MovieService();
        demoGetRealTimeMovieCombinationsExcludeGenre();

    }

    private static void demoGetFromFileMovieCombinations(){
        List<Movie> movies = movieService.readMoviesFromFile();
        List<MovieCombination> movieCombinations = movieService.getMovieCombinations(movies);
        System.out.println(movieCombinations);
    }

    private static void demoGetRealTimeMovieCombinations(){
        List<Movie> movies = movieService.getAllMoviesAfterDateTime(4, "2018-10-29 17:30:00");
        List<MovieCombination> movieCombinations = movieService.getMovieCombinations(movies);
        System.out.println(movieCombinations);
    }

    private static void demoGetRealTimeMovieCombinationsExcludeGenre(){
        List<Movie> movies = movieService.getAllMoviesAfterDateTime(4, "2018-10-29 17:30:00");
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.THRILLER);

        List<MovieCombination> movieCombinations = movieService.getMovieCombinationsExcludeGenres(movies, genres);
        System.out.println(movieCombinations);
    }

}
