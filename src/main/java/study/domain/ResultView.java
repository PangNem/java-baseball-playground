package study.domain;

import java.util.List;
import study.BallStatus;

public class ResultView {

    public void printResult(List<BallStatus> playResults) {
        if (isAllStrike(playResults)) {
            System.out.println("3스트라이크!");
            return;
        }

        if (isAllNothing(playResults)) {
            System.out.println("낫싱");
            return;
        }

        int strikeCount = (int) playResults.stream()
            .filter(playResult -> playResult == BallStatus.STRIKE)
            .count();
        int ballCount = (int) playResults.stream()
            .filter(playResult -> playResult == BallStatus.BALL)
            .count();

        System.out.printf("%s 스트라이크 %s 볼", strikeCount, ballCount);
        System.out.println();
    }

    private boolean isAllNothing(List<BallStatus> playResults) {
        return playResults.stream()
            .allMatch(ballStatus -> ballStatus == BallStatus.NOTHING);
    }

    private boolean isAllStrike(List<BallStatus> playResults) {
        return playResults.stream()
            .allMatch(ballStatus -> ballStatus == BallStatus.STRIKE);
    }

    public int getPlayerGameRestartValue(List<BallStatus> playResults) {
        if (!isAllStrike(playResults)) {
            return 1;
        }
        System.out.println("게임이 종료되었습니다!");
        System.out.println("계속하려면 1, 끝내려면 2를 입력하세요.");

        InputView inputView = new InputView();
        return inputView.getPlayerGameRestartValue();
    }
}
