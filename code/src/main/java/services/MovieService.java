package services;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataModel.Movie;
import dataModel.Performance;


import java.io.File;
import java.io.IOException;
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

    public void readMoviesFromFile(){
        ObjectMapper mapper = new ObjectMapper();
        String pathname = "C:\\code\\movie_mapper\\code\\src\\main\\resources\\all_movies_after_1730_on_29_10_2018.json";
        try {
            List<Movie> movies = mapper.readValue(new File(pathname), new TypeReference<List<Movie>>(){});
            System.out.println(movies);
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
