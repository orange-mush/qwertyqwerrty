package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "���۽ð�: " + format(startDateTime) + " ���డ���ο�: " + capacity + "\n";
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void decreaseCapacity(int reserveNum) {
        capacity -= reserveNum;
    }
}
