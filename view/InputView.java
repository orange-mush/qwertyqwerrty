package view;

import domain.ErrorCheck;
import domain.Movie;
import domain.PlaySchedule;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## ������ ��ȭ�� �����ϼ���.");
        int movieId = scanner.nextInt();
        if(!ErrorCheck.isValidMovieId(movieId))
            return inputMovieId();
        return movieId;
    }

    public static int inputReserveTime(Movie movie) {
        System.out.println("## ������ �ð�ǥ�� �����ϼ���.");
        int reserveTime = scanner.nextInt();
        if(!ErrorCheck.isReserveTimeInBoundary(movie, reserveTime))
            return inputReserveTime(movie);
        if(!ErrorCheck.isOneHourWithinFriendTime(movie, reserveTime))
            return inputReserveTime(movie);
        return reserveTime;
    }

    public static int inputReserveNum(PlaySchedule playSchedule) {
        System.out.println("## ������ �ο��� �Է��ϼ���.");
        int reserveNum = scanner.nextInt();
        if(!ErrorCheck.isCapacible(playSchedule, reserveNum))
            return inputReserveNum(playSchedule);
        return reserveNum;
    }

    public static int inputToBeContinued() {
        System.out.println("## ������ �����ϰ� ������ �����Ϸ��� 1��.�߰� ������ �����Ϸ��� 2��");
        int toBeContinued = scanner.nextInt();
        if(!ErrorCheck.isInCountinuedBoundary(toBeContinued))
            return inputToBeContinued();
        return toBeContinued;
    }

    public static int inputPoint() {
        System.out.println("## ������ �����մϴ�.");
        int point;
        do {
            System.out.println("## ����Ʈ ��� �ݾ��� �Է��ϼ���. ����Ʈ�� ������ 0 �Է�");
            point = scanner.nextInt();
        }while(!ErrorCheck.isValidPoint(point));
        return point;
    }

    public static double inputPayType() {
        System.out.println("## �ſ�ī��� 1��, ������ 2��");
        int payType = scanner.nextInt();
        if(!ErrorCheck.isInCountinuedBoundary(payType))
            return inputPayType();
        if(payType==1)
            return 0.95;
        return 0.98;
    }
}
