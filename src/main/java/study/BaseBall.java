package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBall {

    public static void main(String[] args) {
        Game game = new Game();

        int gameRestartNumber;
        do {
            game.start();
            gameRestartNumber = game.getRestartNumber();
        } while (gameRestartNumber != 2);
    }

    public List<Integer> getRandomNumberList() {
        Set<Integer> randomNumbers = createRandomNumbers();

        return shuffle(randomNumbers);
    }

    public List<Integer> getParsedInputNumberList(String inputNumber) {
        return Arrays.stream(inputNumber.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public int getIsInRandomNumberCount(List<Integer> randomNumberList,
        List<Integer> parsedInputNumberList) {

        return (int) parsedInputNumberList.stream()
            .filter(randomNumberList::contains)
            .count();
    }

    public int getStrikeCount(List<Integer> randomNumberList,
        List<Integer> containsList) {

        return (int) containsList.stream()
            .filter(p -> containsList.indexOf(p) == randomNumberList.indexOf(p))
            .count();
    }


    private List<Integer> shuffle(Set<Integer> randomNumbers) {
        List<Integer> randomNumberList = new ArrayList<>(randomNumbers);
        Collections.shuffle(randomNumberList);
        return randomNumberList;
    }

    private Set<Integer> createRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = (int) (Math.random() * 9) + 1;
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }
}
