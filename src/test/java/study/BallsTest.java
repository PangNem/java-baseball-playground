package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    @DisplayName("숫자와 자리수가 맞을경우 strike를 반환한다")
    void strike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus status = computerBalls.play(new Ball(3, 3));

        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("숫자만 맞을경우 ball을 반환한다")
    void ball() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus status = computerBalls.play(new Ball(1, 3));

        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("아무것도 맞지 않으면 nothing을 반환한다")
    void nothing() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));

        BallStatus status = computerBalls.play(new Ball(1, 5));

        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }


    @Test
    @DisplayName("중복된 숫자를 전달하면 에러를 발생시킨다")
    void duplicatedNumber() {
        assertThatThrownBy(() -> {
            new Balls(Arrays.asList(1, 1, 3));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 볼의 개수를 전달하면 에러를 발생시킨다")
    void invalidBallCount() {
        assertThatThrownBy(() -> {
            new Balls(Arrays.asList(1, 2, 3, 4));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
