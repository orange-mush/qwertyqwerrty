package domain;

import java.time.LocalDateTime;
import static utils.DateTimeUtils.format;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private static final char NEW_LINE = '\n';

    private final Movie movie;
    private final LocalDateTime time;
    private final int num;

    public Reservation(Movie movie, int reserveTime, int reserveNum) {
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        this.movie = movie;
        this.time = playSchedules[reserveTime].getStartDateTime();
        this.num = reserveNum;
        movie.subtractReservedNum(reserveTime, reserveNum);
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return movie.getMovieInfo()
                + "시작시간: " + format(time) + NEW_LINE 
                + "예약 인원: " + num + "명";
    }
}
