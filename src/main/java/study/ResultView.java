package study;

interface ResultViewInterface {

    void printResult(int strike, int ball);
}

public class ResultView implements ResultViewInterface {

    @Override
    public void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2을 입력하세요: ");
            System.out.println();
            return;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
            System.out.println();
            return;
        }

        if (strike == 0) {
            System.out.printf("%s 볼", ball);
            System.out.println();
            return;
        }

        if (ball == 0) {
            System.out.printf("%s 스트라이크", strike);
            System.out.println();
            return;
        }

        System.out.printf("%s 스트라이크 %s 볼", strike, ball);
        System.out.println();
    }
}
