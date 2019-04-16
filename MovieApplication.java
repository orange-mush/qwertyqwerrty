import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        
        while(makeReservation() != 1) {
        }

    }

    // 예약종료일때만 1을 반환하고 나머지 경우에 0을 반환한다.
    public static int makeReservation() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        Movie movieToReserve;
        int movieId;
        do {
            movieId = InputView.inputMovieId();
            movieToReserve = MovieRepository.getMovie(reserveTime);
        } while(!movieToReserve.isValid);
        OutputView.printMovie(movieToReserve);

        do {
            int reserveTime = InputView.inputReserveTime();
        } while(movieToReserve.isValidAtTime(reserveTime));

        do {
        } while(

        // TODO 구현 진행

        do {
        } while(ErrorView.);
    }
}
