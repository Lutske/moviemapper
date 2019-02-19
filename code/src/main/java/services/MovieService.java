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
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    ObjectMapper mapper;

    public MovieService() {
        mapper = new ObjectMapper();
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
        } catch (MalformedURLException e) {

            e.printStackTrace();

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
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> readMoviesFromFile() {
        String pathname = "C:\\code\\movie_mapper\\code\\src\\main\\resources\\all_movies_after_1730_on_29_10_2018.json";
        List<Movie> movies = new ArrayList<>();

        try {
            movies = mapper.readValue(new File(pathname), new TypeReference<List<Movie>>() {
            });
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
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
                    if (movie.getId().equals(baseMovie.getId())) {
                        continue;
                    }

                    for (Performance performance : movie.getPerformances()) {
                        if (basePerformance.getEndDateTime().isBefore(performance.getStartDateTime())) {
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
        List<MovieCombination> movieCombinations = new ArrayList<>();

        for (Movie baseMovie : movies) {
            if (containsGenre(baseMovie.getGenres(), exludeGenres)) {
                continue;
            }

            for (Performance basePerformance : baseMovie.getPerformances()) {
                for (Movie movie : movies) {
                    if (movie.getId().equals(baseMovie.getId()) || containsGenre(movie.getGenres(), exludeGenres)) {
                        continue;
                    }

                    for (Performance performance : movie.getPerformances()) {
                        if (basePerformance.getEndDateTime().isBefore(performance.getStartDateTime())) {
                            MovieCombination combination = new MovieCombination(baseMovie, basePerformance, movie, performance);
                            movieCombinations.add(combination);
                        }

                    }
                }
            }
        }
        return movieCombinations;
    }

    public void prettyPrintAllMovies() {
        prettyPrintAllMovies(Cinema.APELDOORN, "2019-02-21 17:00:00");
    }

    public void prettyPrintAllMovies(Cinema cinema, String dateTime) {
        List<Movie> movies = getAllMoviesAfterDateTime(cinema, dateTime);
        for (Movie movie : movies) {
            for (Performance performance : movie.getPerformances()) {
                System.out.print("\n".concat(performance.getStartTime()).concat(" - ").concat(performance.getEndTime()).concat(" ").concat(movie.getTitle()));
            }
        }
    }

    private boolean containsGenre(String genres, List<Genre> excludeGenres) {
        for (Genre excludedGenre : excludeGenres) {
            if (genres.contains(excludedGenre.genre().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
