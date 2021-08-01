package study.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public List<Integer> getPlayerInput() {
        System.out.print("숫자를 입력해 주세요: ");
        String playerValues = scanner.nextLine();

        return Arrays.stream(playerValues.split(""))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public int getPlayerGameRestartValue() {
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }
}
