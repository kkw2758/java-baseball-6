package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    @DisplayName("입력 받은 숫자가 세자리 숫자가 아니면 예외 처리한다.")
    void numbersLengthExceptionTest() {
        //given & when & then
        assertThatThrownBy(() -> Numbers.generateNumbers(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 받은 숫자에 중복된 숫자가 있으면 예외 처리한다.")
    void numbersDuplicateExceptionTest() {
        //given & when & then
        assertThatThrownBy(() -> Numbers.generateNumbers(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자의 숫자와 컴퓨터의 숫자를 비교하여 같은 위치에 같은 값을 가진 숫자의 개수를 구한다.")
    void calculateMatchNumberCountTest() {
        //given
        Numbers userNumbers = Numbers.generateNumbers(List.of(1, 2, 3));
        Numbers computerNumbers = Numbers.generateNumbers(List.of(3, 2, 1));

        //when
        int result = userNumbers.calculateMatchNumberCount(computerNumbers);
        int expectedResult = 1;

        //then
        assertEquals(result, expectedResult);
    }

    @Test
    @DisplayName("사용자의 숫자와 컴퓨터의 숫자를 비교하여 같은 값을 가진 숫자의 개수를 구한다.")
    void calculateSameNumberCountTest() {
        //given
        Numbers userNumbers = Numbers.generateNumbers(List.of(1, 2, 3));
        Numbers computerNumbers = Numbers.generateNumbers(List.of(3, 2, 1));

        //when
        int result = userNumbers.calculateSameNumberCount(computerNumbers);
        int expectedResult = 3;

        //then
        assertEquals(result, expectedResult);
    }
}
