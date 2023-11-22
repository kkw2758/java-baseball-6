package baseball.domain;

import java.util.Objects;

public class GameNumber {
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 9;

    private final int value;

    private GameNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameNumber from(int value) {
        validateGameNumber(value);
        return new GameNumber(value);
    }

    private static void validateGameNumber(int value) {
        if (checkNotInRange(value)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkNotInRange(int value) {
        return value < MIN_NUMBER_VALUE || value > MAX_NUMBER_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GameNumber gameNumber)) {
            return false;
        }
        return this.value == gameNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
