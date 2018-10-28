package services;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataModel.Movie;
import dataModel.MovieCombination;
import dataModel.Performance;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieService {
    ObjectMapper mapper;

    public MovieService(){
        mapper = new ObjectMapper();
    }


    public List<Movie> getAllMoviesAfterDateTime(int cinemaId, String dateTime) {
        List<Movie> movies = new ArrayList<>();

        if(cinemaId == 0){
            cinemaId = 4;
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

            System.out.println("Output from Server .... \n "+ conn.getInputStream());
            movies = mapper.readValue(conn.getInputStream(), new TypeReference<List<Movie>>(){});

            conn.disconnect();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return movies;
    }

    public void readMovieFromFile(){
        String pathname = "C:\\code\\movie_mapper\\code\\src\\main\\resources\\one_movie.json";
        try {
            Movie movie = mapper.readValue(new File(pathname), Movie.class);
            System.out.println(movie);
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> readMoviesFromFile(){
        String pathname = "C:\\code\\movie_mapper\\code\\src\\main\\resources\\all_movies_after_1730_on_29_10_2018.json";
        List<Movie> movies = new ArrayList<>();

        try {
            movies = mapper.readValue(new File(pathname), new TypeReference<List<Movie>>(){});
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public void getMovieCombinations (List<Movie> movies) {
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
        System.out.println(movieCombinations);
    }
}
