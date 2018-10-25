import services.MovieService;

public class Main {
    static MovieService movieService;

    public static void main(String[] args) {
        movieService = new MovieService();
        movieService.readMovieFromFile();
        movieService.readMoviesFromFile();

    }
}
