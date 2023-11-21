package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    @DisplayName("1~9 범위를 벗어나는 숫자로 Number 생성시 예외 처리한다.")
    @ParameterizedTest
    //given
    @ValueSource(ints = {0, 10})
    void numberExceptionTest(int number) {
        //when && then
        assertThatThrownBy(() -> Number.from(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~9 범위 숫자로 Number 생성시 정상 동작한다.")
    @ParameterizedTest
    //given
    @ValueSource(ints = {1, 9})
    void numberNotExceptionTest(int number) {
        //when && then
        Assertions.assertDoesNotThrow(() -> Number.from(number));
    }
}
