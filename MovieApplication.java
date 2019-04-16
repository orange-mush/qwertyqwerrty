import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.ReservationList;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static final int TO_BE_EXITED = 2;

    public static void main(String[] args) {
        while(makeReservation() != TO_BE_EXITED) {
        }
        OutputView.printReservations(ReservationList.getReservations());
    }

    // 예약종료일때만 1을 반환하고 나머지 경우에 0을 반환한다.
    public static int makeReservation() {
        OutputView.printMovies(MovieRepository.getMovies());
        int movieId= InputView.inputMovieId();
        Movie movieToReserve = MovieRepository.getMovie(movieId);
        OutputView.printMovie(movieToReserve);
        int reserveTime = InputView.inputReserveTime(movieToReserve);
        List<PlaySchedule> playSchedules = movieToReserve.getPlaySchedules();
        int reserveNum = InputView.inputReserveNum(playSchedules[reserveTime]);
        ReservationList.addReservation(new Reservation(movieToReverse, reserveTime, reserveNum));
        return InputView.inputToBeContinued();
    }
}
