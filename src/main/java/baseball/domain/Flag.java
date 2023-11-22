package baseball.domain;

import java.util.Arrays;

public enum Flag {
    RESTART(1),
    END(2);

    private final int number;

    Flag(int number) {
        this.number = number;
    }

    public static Flag findByNumber(int number) {
        return Arrays.stream(Flag.values())
                .filter((flag) -> flag.number == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요."));
    }
}
