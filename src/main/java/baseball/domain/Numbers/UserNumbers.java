package baseball.domain.Numbers;

import baseball.domain.GameNumber;
import java.util.List;

public class UserNumbers extends GameNumbers {

    private UserNumbers(List<Integer> gameNumbers) {
        super(gameNumbers);
    }

    public static UserNumbers of(List<Integer> gameNumbers) {
        return new UserNumbers(gameNumbers);
    }

    protected boolean contain(GameNumber gameNumber) {
        return gameNumbers.contains(gameNumber);
    }

    protected GameNumber getNumberAtPosition(int position) {
        return gameNumbers.get(position);
    }
}
