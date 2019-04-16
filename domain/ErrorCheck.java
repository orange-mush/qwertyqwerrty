package domain;

import java.util.ArrayList;
import java.util.List;

public class ErrorCheck {
    public static boolean isValidMovieId(int movieId) {
        boolean result = false;
        List<Movie> movies = MovieRepository.getMovies();
        for(Movie movie : movies)
            result |= movie.getMovieId == movieId;
        return result;
    }
}
