package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    @ParameterizedTest
    @DisplayName("볼에 잘못된 값을 입력할 경우 에러를 발생시킨다.")
    @CsvSource(value = {"1,10", "1,0", "4,3", "0,5"})
    void invalidArgumentBall(int position, int number) {
        assertThatThrownBy(() -> new Ball(position, number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("볼이 잘 생성되었는지 확인한다.")
    void ball() {
        Ball ball = new Ball(1, 1);
        assertThat(ball.getPosition()).isEqualTo(1);
        assertThat(ball.getNumber()).isEqualTo(1);
    }
}
