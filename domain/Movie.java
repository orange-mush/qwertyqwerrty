package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public List<PlaySchedule> getPlaySchedules() {
        return playSchedules;
    }

    public String getMovieInfo() {
        return id + " - " + name + ", " + price + "��" + NEW_LINE;
    }

    public int getMovieId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void subtractReservedNum(int reserveTime, int reserveNum) {
        playSchedules.get(reserveTime).decreaseCapacity(reserveNum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return getMovieInfo() + sb.toString();
    }
}
