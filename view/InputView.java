package view;

import domain.ErrorCheck;
import domain.Movie;
import domain.PlaySchedule;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        int movieId = scanner.nextInt();
        if(!ErrorCheck.isValidMovieId(movieId))
            return inputMovieId();
        return movieId;
    }

    public static int inputReserveTime(Movie movie) {
        System.out.println("## 예약할 시간표를 선택하세요.");
        int reserveTime = scanner.nextInt();
        if(!ErrorCheck.isReserveTimeInBoundary(movie, reserveTime))
            return inputReserveTime(movie);
        if(!ErrorCheck.isOneHourWithinFriendTime(movie, reserveTime))
            return inputReserveTime(movie);
        return reserveTime;
    }

    public static int inputReserveNum(PlaySchedule playSchedule) {
        System.out.println("## 예약할 인원을 입력하세요.");
        int reserveNum = scanner.nextInt();
        if(!ErrorCheck.isCapacible(playSchedule, reserveNum))
            return inputReserveNum(playSchedule);
        return reserveNum;
    }

    public static int inputToBeContinued() {
        System.out.println("## 예약을 종료하고 결제를 진행하려면 1번.추가 예약을 진행하려면 2번");
        int toBeContinued = scanner.nextInt();
        if(!ErrorCheck.isInCountinuedBoundary(toBeContinued))
            return inputToBeContinued();
        return toBeContinued;
    }

    public static int inputPoint() {
        System.out.println("## 결제를 진행합니다.");
        int point;
        do {
            System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
            point = scanner.nextInt();
        }while(!ErrorCheck.isValidPoint(point));
        return point;
    }

    public static double inputPayType() {
        System.out.println("## 신용카드는 1번, 현금은 2번");
        int payType = scanner.nextInt();
        if(!ErrorCheck.isInCountinuedBoundary(payType))
            return inputPayType();
        if(payType==1)
            return 0.95;
        return 0.98;
    }
}
