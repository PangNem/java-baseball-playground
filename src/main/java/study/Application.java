package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import study.domain.InputView;
import study.domain.NumberGenerator;
import study.domain.ResultView;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> randomNumbers = getRandomNumbers(numberGenerator);
        //System.out.println(randomNumbers);

        Balls computerBall = new Balls(randomNumbers);

        int playerGameRestartValue = 0;
        while (playerGameRestartValue != 2) {
            InputView inputView = new InputView();
            List<Integer> playerValues = inputView.getPlayerInput();

            List<BallStatus> playResults = getBallStatuses(computerBall, playerValues);

            ResultView resultView = new ResultView();
            resultView.printResult(playResults);
            playerGameRestartValue = resultView.getPlayerGameRestartValue(playResults);
        }
    }

    private static List<BallStatus> getBallStatuses(Balls computerBall,
        List<Integer> playerValueList) {
        List<BallStatus> playResults = new ArrayList<>();
        for (int i = 0; i < playerValueList.size(); i++) {
            Ball ball = new Ball(i + 1, playerValueList.get(i));
            BallStatus playResult = computerBall.play(ball);
            playResults.add(playResult);
        }
        return playResults;
    }


    private static List<Integer> getRandomNumbers(NumberGenerator numberGenerator) {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() != 3) {
            int randomNumber = numberGenerator.createRandomNumber();
            randomNumbers.add(randomNumber);
        }
        return shuffle(randomNumbers);
    }

    private static List<Integer> shuffle(Set<Integer> randomNumbers) {
        List<Integer> randomNumberList = new ArrayList<>(randomNumbers);
        Collections.shuffle(randomNumberList);
        return randomNumberList;
    }

}
