package baseball.controller;

import baseball.domain.Flag;
import baseball.domain.Hint;
import baseball.domain.Numbers.ComputerNumbers;
import baseball.domain.Numbers.UserNumbers;
import baseball.utils.RandomUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {
    public void run() {
        OutputView.printStartGameMessage();
        do {
            ComputerNumbers computerNumbers = ComputerNumbers.of(RandomUtil.createRandomNumbers());
            printHintUntilGameEnd(computerNumbers);
            OutputView.printGameEndMessage();
        } while (isRestart());
    }

    private void printHintUntilGameEnd(ComputerNumbers computerNumbers) {
        while (true) {
            Hint hint = generateHint(computerNumbers);
            OutputView.printHint(hint.getStrikeCount(), hint.getBallCount(), hint.isNothing());
            if (isGameEnd(hint.getStrikeCount())) {
                break;
            }
        }
    }

    private Hint generateHint(ComputerNumbers computerNumbers) {
        UserNumbers userNumbers = UserNumbers.of(InputView.requestUserNumber());
        return Hint.of(computerNumbers, userNumbers);
    }

    private boolean isGameEnd(int strikeCount) {
        return strikeCount == 3;
    }

    private boolean isRestart() {
        return InputView.requestFlag().equals((Flag.RESTART));
    }
}
