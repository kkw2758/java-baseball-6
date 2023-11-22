package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FlagTest {
    @Test
    @DisplayName("사용자가 입력한 플레그 값이 1이면 Restart 플래그를 반환한다.")
    void findRestartTest() {
        //given
        int number = 1;
        //when & then
        assertEquals(Flag.findByNumber(number), Flag.RESTART);
    }

    @Test
    @DisplayName("사용자가 입력한 플레그 값이 2이면 END 플래그를 반환한다.")
    void findEndFlagTest() {
        //given
        int number = 2;
        //when & then
        assertEquals(Flag.findByNumber(number), Flag.END);
    }

    @DisplayName("1 또는 2 이외의 플래그 값을 입력하면 에러가 발생한다.")
    @ParameterizedTest
    //given
    @ValueSource(ints = {0, 3})
    void numberExceptionTest(int number) {
        //when && then
        assertThatThrownBy(() -> Flag.findByNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
    }
}
