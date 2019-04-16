package view;

import.domain.ErrorCheck;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId = scanner.nextInt();
        if(!ErrorCheck.isValidMovieId(movieId)
            return inputMovieId();
        return movieId;
    }

    public static int inputReserveTime(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요.");
        int reserveTime = scanner.nextInt();
        if(!ErrorCheck.isReserveTimeInBoundary(movie, reserveTime))
            return inputReserveTime();
        if(!ErrorCheck.isOneHourWithinFriendTime(movie, reserveTime))
            return inputReserveTime();
        return reserveTime;
    }

    public static int inputToBeContinued() {
        int toBeContinued = scanner.nextInt();
        if(!isInCountinuedBoundary(toBeContinued))
            return inputToBeContinued();
        return toBeContinued;
    }
}
