package study.domain;

public class NumberGenerator {

    public int createRandomNumber() {
        int MIN_NUMBER = 1;
        int MAX_NUMBER = 9;

        return ((int) (Math.random() * MAX_NUMBER)) + MIN_NUMBER;
    }
}
