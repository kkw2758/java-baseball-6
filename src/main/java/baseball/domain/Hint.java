package baseball.domain;

import baseball.domain.Numbers.ComputerNumbers;
import baseball.domain.Numbers.UserNumbers;

public class Hint {

    private final int strikeCount;
    private final int ballCount;

    private Hint(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Hint of(ComputerNumbers computerNumbers, UserNumbers userNumbers) {
        int matchNumberCount = computerNumbers.calculateMatchNumberCount(userNumbers);
        int sameNumberCount = computerNumbers.calculateSameNumberCount(userNumbers);
        return new Hint(
                matchNumberCount,
                sameNumberCount - matchNumberCount
        );
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
