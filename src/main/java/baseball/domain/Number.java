package baseball.domain;

public class Number {
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 9;

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Number from(int number) {
        validateNumber(number);
        return new Number(number);
    }

    private static void validateNumber(int number) {
        if (checkNumberNotInRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkNumberNotInRange(int number) {
        return number < MIN_NUMBER_VALUE || number > MAX_NUMBER_VALUE;
    }
}
