package baseball.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Number numberObject)) {
            return false;
        }
        return number == numberObject.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
