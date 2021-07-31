package study;

import java.util.List;
import java.util.Scanner;

public class Game {

    public void start() {
        BaseBall baseBall = new BaseBall();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<Integer> randomNumberList = baseBall.getRandomNumberList();
        int strikeCount = 0;
        while (strikeCount != 3) {
            inputView.printInputNumber();
            String inputNumber = inputView.getInputNumber();

            List<Integer> parsedInputNumberList = baseBall
                .getParsedInputNumberList(inputNumber);

            int isInRandomNumberCount = baseBall
                .getIsInRandomNumberCount(randomNumberList, parsedInputNumberList);
            strikeCount = baseBall.getStrikeCount(randomNumberList, parsedInputNumberList);
            int ballCount = isInRandomNumberCount - strikeCount;

            resultView.printResult(strikeCount, ballCount);
        }
    }

    public int getRestartNumber() {
        Scanner scanner = new Scanner(System.in);
        String userValueInput = scanner.nextLine();
        return Integer.parseInt(userValueInput);
    }

}
