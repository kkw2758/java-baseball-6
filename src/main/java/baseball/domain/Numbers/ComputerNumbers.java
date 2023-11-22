package baseball.domain.Numbers;

import java.util.List;
import java.util.stream.IntStream;

public class ComputerNumbers extends GameNumbers {

    private ComputerNumbers(List<Integer> gameNumbers) {
        super(gameNumbers);
    }

    public static ComputerNumbers of(List<Integer> gameNumbers) {
        return new ComputerNumbers(gameNumbers);
    }

    public int calculateSameNumberCount(UserNumbers gameNumbers) {
        return this.gameNumbers.stream()
                .filter(gameNumbers::contain)
                .toList()
                .size();
    }

    public int calculateMatchNumberCount(UserNumbers gameNumbers) {
        return (int) IntStream.range(0, this.gameNumbers.size())
                .filter(i -> this.gameNumbers.get(i).equals(gameNumbers.getNumberAtPosition(i)))
                .count();
    }
}
