package baseball.view;

import baseball.domain.Flag;
import baseball.view.console.ConsoleReader;
import baseball.view.console.ConsoleWriter;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "\\d+";
    private static final String NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FLAG_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static List<Integer> requestUserNumber() {
        ConsoleWriter.printMessage(NUMBER_REQUEST_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return parseStringToIntegerList(userInput);
    }

    public static Flag requestFlag() {
        ConsoleWriter.printMessage(FLAG_REQUEST_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Flag.findByNumber(Integer.parseInt(userInput));
    }

    private static void validateNumber(String userInput) {
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> parseStringToIntegerList(String userInput) {
        return Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .toList();
    }

    private static boolean isNotNumber(String userInput) {
        return !userInput.matches(NATURAL_NUMBER_REGULAR_EXPRESSION);
    }
}
