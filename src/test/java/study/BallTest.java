package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallTest {

    Ball computerBall;

    @BeforeEach
    void setup() {
        computerBall = new Ball(1, 1);
    }

    @Test
    @DisplayName("strike 케이스")
    void strike() {
        Ball playerBall = new Ball(1, 1);

        BallStatus status = computerBall.play(playerBall);

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("ball 케이스")
    void ball() {
        Ball playerBall = new Ball(2, 1);

        BallStatus status = computerBall.play(playerBall);

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("nothing 케이스")
    void nothing() {
        Ball playerBall = new Ball(1, 2);

        BallStatus status = computerBall.play(playerBall);

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @ParameterizedTest
    @DisplayName("볼에 잘못된 값을 입력할 경우 에러를 발생시킨다.")
    @CsvSource(value = {"1,10", "1,0", "4,3", "0,5"})
    void invalidArgumentBall(int position, int number) {
        assertThatThrownBy(() -> new Ball(position, number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
