package baseball.domain;

public class Hint {

    private final int strikeCount;
    private final int ballCount;

    private Hint(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static Hint of(Numbers computerNumbers, Numbers userNumbers) {
        return new Hint(
                computerNumbers.calculateMatchNumberCount(userNumbers),
                computerNumbers.calculateSameNumberCount(userNumbers)
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
