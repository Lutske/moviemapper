package dataModel;

public class MovieCombination {
    private Movie firstMovie;
    private Movie secondMovie;
    private Performance firstPerformance;
    private Performance secondPerformance;

    public MovieCombination(){}

    public MovieCombination(Movie firstMovie, Performance firstPerformance, Movie secondMovie, Performance secondPerformance) {
        this.firstMovie = firstMovie;
        this.secondMovie = secondMovie;
        this.firstPerformance = firstPerformance;
        this.secondPerformance = secondPerformance;
    }

    public void setFirstMoviePerformance(Movie firstMovie, Performance firstPerformance){
        this.firstMovie = firstMovie;
        this.firstPerformance = firstPerformance;
    }

    public void seSecondMoviePerformance(Movie secondMovie, Performance secondPerformance){
        this.secondMovie = secondMovie;
        this.secondPerformance = secondPerformance;
    }

    public Movie getFirstMovie() {
        return firstMovie;
    }

    public void setFirstMovie(Movie firstMovie) {
        this.firstMovie = firstMovie;
    }

    public Movie getSecondMovie() {
        return secondMovie;
    }

    public void setSecondMovie(Movie secondMovie) {
        this.secondMovie = secondMovie;
    }

    public Performance getFirstPerformance() {
        return firstPerformance;
    }

    public void setFirstPerformance(Performance firstPerformance) {
        this.firstPerformance = firstPerformance;
    }

    public Performance getSecondPerformance() {
        return secondPerformance;
    }

    public void setSecondPerformance(Performance secondPerformance) {
        this.secondPerformance = secondPerformance;
    }

    @Override
    public String toString() {
        return "\n".concat(firstPerformance.getStartTime()).concat(" - ").concat(firstPerformance.getEndTime()).concat(" ").concat(firstMovie.getTitle()).concat("\n").concat(
                secondPerformance.getStartTime().concat(" - ").concat(secondPerformance.getEndTime()).concat(" ").concat(secondMovie.getTitle().concat("\n"))
        );
    }
}
