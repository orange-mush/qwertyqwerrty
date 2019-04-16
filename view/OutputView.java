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
    	System.out.println("���� ����");
        for (Reservation reservation: reservations) {
            System.out.println(reservation);
        }
    }
    public static void printResult(int price) {
        System.out.println("���� ������ �ݾ��� " + price + "�� �Դϴ�.");
        System.out.println("���Ÿ� �Ϸ��߽��ϴ�. ��ſ� ��ȭ �����Ǽ���.");
    }
}
