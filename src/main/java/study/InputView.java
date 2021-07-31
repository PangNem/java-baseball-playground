package study;

import java.util.Scanner;

public class InputView {

    private static final int VALIDATE_LENGTH = 3;

    public void printInputNumber() {
        System.out.print("숫자를 입력해 주세요: ");
    }

    public String getInputNumber() {
        Scanner scanner = new Scanner(System.in);

        String inputNumber = scanner.nextLine();
        if (isValidateLength(inputNumber)) {
            throw new IllegalArgumentException("숫자 길이가" + VALIDATE_LENGTH + "이 아닙니다.");
        }

        return inputNumber;
    }

    private boolean isValidateLength(String inputNumber) {
        return inputNumber.length() != VALIDATE_LENGTH;
    }
}
