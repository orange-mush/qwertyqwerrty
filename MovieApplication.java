

import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import domain.PlaySchedule;
import domain.ReservationList;
import view.InputView;
import view.OutputView;
import java.util.List;

public class MovieApplication {
    public static final int TO_BE_EXITED = 1;

    public static void main(String[] args) {
        while(makeReservation() != TO_BE_EXITED) {
        }
        OutputView.printReservations(ReservationList.getReservations());
        int point = InputView.inputPoint();
        int price = (int)((double)(ReservationList.getTotalPrice() - point) * (double)InputView.inputPayType());
        OutputView.printResult(price);
    }

    // 예약종료일때만 1을 반환하고 나머지 경우에 0을 반환한다.
    public static int makeReservation() {
        OutputView.printMovies(MovieRepository.getMovies());
        int movieId= InputView.inputMovieId();
        Movie movieToReserve = MovieRepository.getMovie(movieId);
        OutputView.printMovie(movieToReserve);
        int reserveTime = InputView.inputReserveTime(movieToReserve);
        List<PlaySchedule> playSchedules = movieToReserve.getPlaySchedules();
        int reserveNum = InputView.inputReserveNum(playSchedules.get(reserveTime));
        ReservationList.addReservation(new Reservation(movieToReserve, reserveTime, reserveNum));
        if(InputView.inputToBeContinued()==TO_BE_EXITED)
        	return TO_BE_EXITED;
        return 0;
    }
}
