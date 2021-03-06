package domain;

import java.util.List;
import utils.DateTimeUtils;

public class ErrorCheck {
    public static final int TO_BE_EXITED = 2;
    public static final int TO_BE_CONTINUEED = 1;

    public static boolean isValidMovieId(int movieId) {
        boolean result = false;
        List<Movie> movies = MovieRepository.getMovies();
        for(Movie movie : movies)
            result |= movie.getMovieId() == movieId;
        if(!result)
            System.out.println("Error! - 유효하지 않은 영화 번호입니다. 다시 입력해주세요.");
        return result;
    }

    public static boolean isReserveTimeInBoundary(Movie movie, int reserveTime) {
        boolean result = false;
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        result |= (reserveTime <= playSchedules.size() && reserveTime > 0);
        if(!result)
            System.out.println("Error! - 가능한 시간표 번호 범위가 아닙니다. 다시 입력해주세요.");
        return result;
    }

    public static boolean isOneHourWithinFriendTime(Movie movie, int reserveTime) {
        boolean result = true;
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        List<Reservation> reservations = ReservationList.getReservations();
        for(Reservation reservation : reservations) {
            result &= DateTimeUtils.isOneHourWithinRange(playSchedules.get(reserveTime).getStartDateTime(), reservation.getTime());
        }
        if(!result)
            System.out.println("Error! - 가능한 시간표 번호 범위가 아닙니다. 다시 입력해주세요.");
        return result;
    }

    public static boolean isCapacible(PlaySchedule playSchedule, int reserveNum) {
        if(playSchedule.getCapacity() >= reserveNum)
            return true;
        System.out.println("Error! - 예약가능인원을 초과했습니다. 다시 입력해주세요.");
        return false;
    }

    public static boolean isInCountinuedBoundary(int toBeContinued) {
         if(toBeContinued != TO_BE_EXITED && toBeContinued != TO_BE_CONTINUEED) {
            System.out.println("Error! - 1 또는 2를 입력해주세요.");
            return false;
         }
         return true;
    }

    public static boolean isValidPoint(int point) {
        if(point < 0) {
            System.out.println("Error! - 포인트 사용량은 음수일 수 없습니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }
}
