package baseball.view;

import baseball.view.console.ConsoleWriter;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartGameMessage() {
        ConsoleWriter.printlnMessage(START_GAME_MESSAGE);
    }

    public static void printGameEndMessage() {
        ConsoleWriter.printlnMessage(GAME_END_MESSAGE);
    }

    public static void printHint(int strikeCount, int ballCount, boolean nothing) {
        if (nothing) {
            printNothingMessage();
            return;
        }
        printBallMessage(ballCount);
        printStrikeMessage(strikeCount);
        ConsoleWriter.printlnMessage("");
    }

    private static void printStrikeMessage(int strikeCount) {
        ConsoleWriter.printlnFormat(STRIKE_MESSAGE, strikeCount);
    }

    private static void printBallMessage(int ballCount) {
        if (ballCount != 0) {
            ConsoleWriter.printFormat(BALL_MESSAGE, ballCount);
            ConsoleWriter.printMessage(" ");
        }
    }

    private static void printNothingMessage() {
        ConsoleWriter.printlnMessage(NOTHING_MESSAGE);
    }
}
