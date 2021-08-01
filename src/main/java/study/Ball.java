package study;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        if (position <= 0 || position >= 4) {
            throw new IllegalArgumentException("포지션은 1부터 3까지여야 합니다.");
        }
        this.position = position;
        if (number <= 0 || number >= 10) {
            throw new IllegalArgumentException("숫자는 1부터 9까지여야 합니다.");
        }
        this.number = number;
    }

    public BallStatus play(Ball playerBall) {
        if (this.equals(playerBall)) {
            return BallStatus.STRIKE;
        }
        if (isMatchNumber(playerBall)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isMatchNumber(Ball playerBall) {
        return playerBall.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    public int getNumber() {
        return this.number;
    }
}
