package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBall {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BaseBall baseBall = new BaseBall();

        List<Integer> randomNumberList = baseBall.getRandomNumberList();

        inputView.printInputNumber();
        String inputNumber = inputView.getInputNumber();

        List<Integer> parsedInputNumberList = baseBall.getParsedInputNumberList(inputNumber);
    }

    public List<Integer> getRandomNumberList() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = (int) (Math.random() * 9) + 1;
            randomNumbers.add(randomNumber);
        }

        List<Integer> randomNumberList = new ArrayList<>(randomNumbers);
        Collections.shuffle(randomNumberList);

        return randomNumberList;
    }

    public List<Integer> getParsedInputNumberList(String inputNumber) {
        List<Integer> inputNumberList = new ArrayList<>();
        for (String splitedInputNumber : inputNumber.split("")) {
            int parseSplitedInputNumber = Integer.parseInt(splitedInputNumber);
            inputNumberList.add(parseSplitedInputNumber);
        }
        return inputNumberList;
    }
}
