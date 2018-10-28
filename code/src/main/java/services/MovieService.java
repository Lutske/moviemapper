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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MovieService {



    public void getAllMoviesAfterTime(int movieId, String dateTime) {
        if(movieId == 0){
            movieId = 4;
        }
    }

    public void readMovieFromFile(){
        ObjectMapper mapper = new ObjectMapper();
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
        ObjectMapper mapper = new ObjectMapper();
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

        Movie beginMovie = movies.get(0);
        Performance beginPerformance = beginMovie.getPerformances().get(0);

        for (Movie movie : movies) {
            if(movie.getId().equals(beginMovie.getId())){
                continue;
            }

            for (Performance performance: movie.getPerformances()) {
                if(beginPerformance.getEndDateTime().isBefore(performance.getStartDateTime())){
                    MovieCombination combination = new MovieCombination(beginMovie, beginPerformance, movie, performance );
                    movieCombinations.add(combination);
                }

            }
        }
        System.out.println(movieCombinations);
    }

}
