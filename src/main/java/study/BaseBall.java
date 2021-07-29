package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseBall {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printInputNumber();
        String inputNumber = inputView.getInputNumber();

        System.out.println(inputNumber);
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
}
