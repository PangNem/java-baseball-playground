package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import study.domain.NumberGenerator;

public class Application {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();

        List<Integer> randomNumbers = getRandomNumbers(numberGenerator);
        System.out.println(randomNumbers);

        Balls balls = new Balls(randomNumbers);

        Scanner scanner = new Scanner(System.in);
        String playerValues = scanner.nextLine();

        List<Integer> playerValueList = Arrays.stream(playerValues.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        for (int i = 0; i < playerValueList.size(); i++) {
            Ball ball = new Ball(i + 1, playerValueList.get(i));
            BallStatus playResult = balls.play(ball);
            System.out.println(playResult);
        }
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
