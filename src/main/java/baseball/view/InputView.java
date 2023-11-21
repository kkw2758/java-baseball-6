package baseball.view;

import baseball.view.console.ConsoleReader;
import baseball.view.console.ConsoleWriter;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "\\d+";
    private static final String NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";

    public static List<Integer> requestUserNumber() {
        ConsoleWriter.printMessage(NUMBER_REQUEST_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumbers(userInput);
        return parseStringToIntegerList(userInput);
    }

    private static void validateNumbers(String userInput) {
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
