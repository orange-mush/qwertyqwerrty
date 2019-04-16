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
            System.out.println("Error! - ��ȿ���� ���� ��ȭ ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
        return result;
    }

    public static boolean isReserveTimeInBoundary(Movie movie, int reserveTime) {
        boolean result = false;
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        result |= (reserveTime <= playSchedules.size() && reserveTime > 0);
        if(!result)
            System.out.println("Error! - ������ �ð�ǥ ��ȣ ������ �ƴմϴ�. �ٽ� �Է����ּ���.");
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
            System.out.println("Error! - ������ �ð�ǥ ��ȣ ������ �ƴմϴ�. �ٽ� �Է����ּ���.");
        return result;
    }

    public static boolean isCapacible(PlaySchedule playSchedule, int reserveNum) {
        if(playSchedule.getCapacity() >= reserveNum)
            return true;
        System.out.println("Error! - ���డ���ο��� �ʰ��߽��ϴ�. �ٽ� �Է����ּ���.");
        return false;
    }

    public static boolean isInCountinuedBoundary(int toBeContinued) {
         if(toBeContinued != TO_BE_EXITED && toBeContinued != TO_BE_CONTINUEED) {
            System.out.println("Error! - 1 �Ǵ� 2�� �Է����ּ���.");
            return false;
         }
         return true;
    }

    public static boolean isValidPoint(int point) {
        if(point < 0) {
            System.out.println("Error! - ����Ʈ ��뷮�� ������ �� �����ϴ�. �ٽ� �Է����ּ���.");
            return false;
        }
        return true;
    }
}
