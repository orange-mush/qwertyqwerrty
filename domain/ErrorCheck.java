package domain;

import java.util.ArrayList;
import java.util.List;

public class ErrorCheck {
    public static boolean isValidMovieId(int movieId) {
        boolean result = false;
        List<Movie> movies = MovieRepository.getMovies();
        for(Movie movie : movies)
            result |= movie.getMovieId == movieId;
        if(!result)
            System.out.println("Error! - 유효하지 않은 영화 번호입니다. 다시 입력해주세요.");
        return result;
    }
}
