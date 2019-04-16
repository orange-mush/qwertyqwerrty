package domain;

import java.util.ArrayList;
import java.util.List;
import.utils.DateTimeUtils;

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

    public static boolean isReserveTimeInBoundary(Movie movie, int reserveTime) {
        boolean result = false;
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        result |= (reserveTime <= playSchedules.length() && reserveTime > 0);
        if(!result)
            System.out.println("Error! - 가능한 시간표 번호 범위가 아닙니다. 다시 입력해주세요.");
        return result;
    }

    public static boolean isOneHourWithinFriendTime(Movie movie, int reserveTime) {
        boolean result = true;
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        List<Reservation> reservations = ReservationList.getReservations();
        for(Reservation reservation : reservations) {
            result &= DateTimeUtils.isOneHourWithinRange(playSchedules[reserveTime].getStartDateTime(), reservation.getTime());
        }
        if(!result)
            System.out.println("Error! - 가능한 시간표 번호 범위가 아닙니다. 다시 입력해주세요.");
        return result;
    }
}
