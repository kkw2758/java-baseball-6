package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Numbers generateRandomNumbers() {
        return new Numbers(createRandomNumbers().stream()
                .map(Number::from)
                .toList());
    }

    private static List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public static Numbers generateNumbers(List<Integer> numbers) {
        return new Numbers(numbers.stream()
                .map(Number::from)
                .toList());
    }

    private void validateNumbers(List<Number> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Number> numbers) {
        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야합니다.");
        }
    }

    private boolean checkDuplicate(List<Number> numbers) {
        return numbers.stream()
                .distinct()
                .toList().size() != numbers.size();
    }

    private void validateLength(List<Number> numbers) {
        if (checkNumbersLength(numbers)) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야합니다.");
        }
    }

    private boolean checkNumbersLength(List<Number> numbers) {
        return numbers.size() != 3;
    }
}
