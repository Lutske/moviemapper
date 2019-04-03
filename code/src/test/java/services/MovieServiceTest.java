package services;

import dataModel.Movie;
import dataModel.MovieCombination;
import enums.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieServiceTest {
    private MovieService movieService = new MovieService();

    @Test
    @DisplayName("Read movies from file")
    void readMoviesFromFile(){
        List<Movie> movies = movieService.readMoviesFromFile();

        assertEquals(11, movies.size(), "Wrong number of movies");

        movies = movieService.read3MoviesFromFile();

        assertEquals(3, movies.size(), "Wrong number of movies");
    }

    @Test
    @DisplayName("Get movie combinations")
    void getMovieCombinations(){
        List<Movie> movies = movieService.readMoviesFromFile();
        List<MovieCombination> movieCombinations = movieService.getMovieCombinations(movies);

        assertEquals(11, movies.size(), "Wrong number of movies");
        assertEquals(13, movieCombinations.size(), "Wrong number of moviecombinations");

        movies = movieService.read3MoviesFromFile();
        movieCombinations = movieService.getMovieCombinations(movies);

        assertEquals(3, movies.size(), "Wrong number of movies");
        assertEquals(2, movieCombinations.size(), "Wrong number of moviecombinations");

    }

    @Test
    @DisplayName("Get movie combinations without genre")
    void getMovieCombinationsExcludeGenres(){
        List<Genre> excludeGenres = new ArrayList<>();
        excludeGenres.add(Genre.THRILLER);
        excludeGenres.add(Genre.HORROR);

        List<Movie> movies = movieService.readMoviesFromFile();
        List<MovieCombination> movieCombinations = movieService.getMovieCombinationsExcludeGenres(movies, excludeGenres);

        assertEquals(11, movies.size(), "Wrong number of movies");
        assertEquals(4, movieCombinations.size(), "Wrong number of moviecombinations");

        movies = movieService.read3MoviesFromFile();
        movieCombinations = movieService.getMovieCombinationsExcludeGenres(movies, excludeGenres);

        assertEquals(3, movies.size(), "Wrong number of movies");
        assertEquals(1, movieCombinations.size(), "Wrong number of moviecombinations");
    }
}
