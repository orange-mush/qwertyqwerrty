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
    private final int price;

    public Reservation(Movie movie, int reserveTime, int reserveNum) {
        List<PlaySchedule> playSchedules = movie.getPlaySchedules();
        this.movie = movie;
        this.time = playSchedules.get(reserveTime).getStartDateTime();
        this.num = reserveNum;
        movie.subtractReservedNum(reserveTime, reserveNum);
        this.price = movie.getPrice() * this.num;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return movie.getMovieInfo()
                + "시작시간: " + format(time) + NEW_LINE 
                + "예약 인원: " + num + "명";
    }
}
