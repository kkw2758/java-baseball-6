package baseball.domain.Numbers;

import baseball.domain.GameNumber;
import java.util.List;

public abstract class GameNumbers {
    protected final List<GameNumber> gameNumbers;

    public GameNumbers(List<Integer> gameNumbers) {
        validateGameNumbers(gameNumbers);
        this.gameNumbers = intListToNumberList(gameNumbers);
    }

    private List<GameNumber> intListToNumberList(List<Integer> gameNumbers) {
        return gameNumbers.stream()
                .map(GameNumber::from)
                .toList();
    }

    private void validateGameNumbers(List<Integer> gameNumbers) {
        validateLength(gameNumbers);
        validateDuplicate(gameNumbers);
    }

    private void validateDuplicate(List<Integer> gameNumbers) {
        if (checkDuplicate(gameNumbers)) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야합니다.");
        }
    }

    private boolean checkDuplicate(List<Integer> gameNumbers) {
        return gameNumbers.stream()
                .distinct()
                .toList().size() != gameNumbers.size();
    }

    private void validateLength(List<Integer> gameNumbers) {
        if (checkNumbersLength(gameNumbers)) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야합니다.");
        }
    }

    private boolean checkNumbersLength(List<Integer> gameNumbers) {
        return gameNumbers.size() != 3;
    }
}
