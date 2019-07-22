package services;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataModel.Movie;
import dataModel.MovieCombination;
import dataModel.Performance;
import enums.Cinema;
import enums.Genre;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    ObjectMapper mapper;

    public MovieService() {
        mapper = new ObjectMapper();
    }

    public String localDateTimeToString(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public LocalDateTime stringToLocalDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTime, formatter);
    }

    public List<Movie> getAllMoviesAfterDateTime(Cinema cinema, LocalDateTime localDateTime) {
        return getAllMoviesAfterDateTime(cinema.cinemaId(), localDateTimeToString(localDateTime));
    }

    public List<Movie> getAllMoviesAfterDateTime(Cinema cinema, String dateTime) {
        return getAllMoviesAfterDateTime(cinema.cinemaId(), dateTime);
    }

    public List<Movie> getAllMoviesAfterDateTime(int cinemaId, String dateTime) {
        List<Movie> movies = new ArrayList<>();

        if (cinemaId < 1 || cinemaId > 23) {
            cinemaId = Cinema.APELDOORN.cinemaId();
        }

        System.out.println("Get movies after " + dateTime);
        dateTime = dateTime.replaceAll(" ", "+");

        try {
            URL url = new URL("https://www.vuecinemas.nl/movies.json?type=NOW_PLAYING_WITH_PERFORMANCES&filters%5Bcinema_id%5D%5B%5D=in&filters%5Bcinema_id%5D%5B%5D=" + cinemaId + "&dateOffset=" + dateTime + "&range=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            movies = mapper.readValue(conn.getInputStream(), new TypeReference<List<Movie>>() {
            });

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public void readMovieFromFile() {
        String pathname = "C:\\code\\movie_mapper\\code\\src\\main\\resources\\one_movie.json";
        try {
            Movie movie = mapper.readValue(new File(pathname), Movie.class);
            System.out.println(movie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> read3MoviesFromFile(){
        return readMoviesFromFile("C:\\code\\movie_mapper\\code\\src\\main\\resources\\3_movies.json");
    }

    public List<Movie> readMoviesFromFile(){
        return readMoviesFromFile("C:\\code\\movie_mapper\\code\\src\\main\\resources\\all_movies_after_1730_on_29_10_2018.json");
    }

    public List<Movie> readMoviesFromFile(String pathname) {
        List<Movie> movies = new ArrayList<>();

        try {
            movies = mapper.readValue(new File(pathname), new TypeReference<List<Movie>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public List<MovieCombination> getMovieCombinations(List<Movie> movies) {
        List<MovieCombination> movieCombinations = new ArrayList<>();

        for (Movie baseMovie : movies) {
            for (Performance basePerformance : baseMovie.getPerformances()) {
                for (Movie movie : movies) {
                    if (isTheSameMovie(baseMovie, movie)) {
                        continue;
                    }

                    for (Performance performance : movie.getPerformances()) {
                        if (startsBeforeOtherPerformanceInReasonableTime(basePerformance, performance)) {
                            MovieCombination combination = new MovieCombination(baseMovie, basePerformance, movie, performance);
                            movieCombinations.add(combination);
                        }
                    }
                }
            }
        }
        return movieCombinations;
    }

    public List<MovieCombination> getMovieCombinationsExcludeGenres(List<Movie> movies, List<Genre> exludeGenres) {
        List<Movie> moviesWithRightGenres = movies.stream()
                .filter(baseMovie -> !containsGenre(baseMovie.getGenres(), exludeGenres))
                .collect(Collectors.toList());

        return getMovieCombinations(moviesWithRightGenres);
    }

    public void prettyPrintAllMovies() {
        prettyPrintAllMovies(Cinema.APELDOORN, localDateTimeToString(LocalDateTime.now()));
    }

    public void prettyPrintAllMovies(String dateTime) {
        prettyPrintAllMovies(Cinema.APELDOORN, dateTime);
    }

    public void prettyPrintAllMovies(LocalDateTime localDateTime) {
        prettyPrintAllMovies(Cinema.APELDOORN, localDateTimeToString(localDateTime));
    }

    public void prettyPrintAllMovies(Cinema cinema, String startDateTime) {
        List<Movie> movies = getAllMoviesAfterDateTime(cinema, startDateTime);
        prettyPrintMovies(movies);
    }

    public void prettyPrintMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            for (Performance performance : movie.getPerformances()) {
                System.out.print("\n".concat(performance.getStartTime()).concat(" - ").concat(performance.getEndTime()).concat(" ").concat(movie.getTitle()));
            }
        }
    }

    private boolean isTheSameMovie(Movie baseMovie, Movie movie){
        return movie.getId().equals(baseMovie.getId());
    }

    private boolean containsGenre(String genres, List<Genre> excludeGenres) {
        for (Genre excludedGenre : excludeGenres) {
            if (genres.contains(excludedGenre.genre().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean startsBeforeOtherPerformanceInReasonableTime(Performance basePerformance, Performance performance){
        boolean startsBeforeMovie = basePerformance.getEndDateTime().isBefore(performance.getStartDateTime());
        boolean startsInReaonableTime = basePerformance.getEndDateTime().plusMinutes(45).isAfter(performance.getStartDateTime());
        return startsBeforeMovie && startsInReaonableTime;
    }
}
