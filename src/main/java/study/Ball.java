package study;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        if (position <= 0 || position >= 4) {
            throw new IllegalArgumentException("포지션은 1부터 3까지여야 합니다.");
        }
        this.position = position;
        if (number <= 0 || number >= 10) {
            throw new IllegalArgumentException("숫자는 1부터 9까지여야 합니다.");
        }
        this.number = number;
    }


    public int getPosition() {
        return this.position;
    }

    public int getNumber() {
        return this.number;
    }
}
