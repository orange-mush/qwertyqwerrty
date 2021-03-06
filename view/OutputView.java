package view;

import domain.Movie;
import domain.Reservation;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public static void printMovie(Movie movie) {
        System.out.println(movie);
    }
    public static void printReservations(List<Reservation> reservations) {
    	System.out.println("예약 내역");
        for (Reservation reservation: reservations) {
            System.out.println(reservation);
        }
    }
    public static void printResult(int price) {
        System.out.println("최종 결제한 금액은 " + price + "원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");
    }
}
