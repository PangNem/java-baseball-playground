package study;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private static final int BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Integer> computerBalls) {
        checkBallCount(computerBalls);
        checkDuplicateBallNumber(computerBalls);
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < BALL_COUNT; i++) {
            balls.add(new Ball(i + 1, computerBalls.get(i)));
        }

        this.balls = balls;
    }

    private void checkDuplicateBallNumber(List<Integer> computerBalls) {
        int ballNumberCount = (int) computerBalls.stream().distinct().count();
        if (ballNumberCount != BALL_COUNT) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    private void checkBallCount(List<Integer> computerBalls) {
        if (computerBalls.size() != BALL_COUNT) {
            throw new IllegalArgumentException("볼의 개수는" + BALL_COUNT + "개여야 합니다.");
        }
    }

    public BallStatus play(Ball ball) {
        return this.balls.stream()
            .map(computerBall -> computerBall.play(ball))
            .filter(this::isNotNothing)
            .findFirst()
            .orElse(BallStatus.NOTHING);
    }

    private boolean isNotNothing(BallStatus ballStatus) {
        return ballStatus != BallStatus.NOTHING;
    }
}
