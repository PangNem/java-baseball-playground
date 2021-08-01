## 기능 요구 사항

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를
  맞추면 승리한다.
    - e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱 {- 위
      숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를
      입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## 요구 사항에 따른 기능 구현 목록

[x] 컴퓨터는 1~9 사이의 서로 다른 랜덤한 3개의 숫자를 생성한다. NumberGenerator#createRandomNumber()

- [x] 1~9 사이인가?
- [x] 중복되지 않은, 즉 서로 다른 숫자인가?
- [x] 3자리인가?

[] 사용자는 1~9 사이의 숫자 3개를 입력한다.
[] 컴퓨터가 생성한 랜덤한 숫자와 사용자로부터 입력받은 숫자를 비교한다.

- [] 숫자와 자릿수 모두 일치하지 않은 경우: nothing
- [] 숫자가 일치하지만 자릿수는 다른 경우: ball
- [] 숫자가 일치하고 자릿수까지 일치한 경우: strike
    - [] strike가 3개일 경우 입력값에 따라 게임을 재시작하거나 종료할 수 있다.
        - 1일 경우 재시작, 2일 경우 종료

### 생각 메모

123 / 1 5 -> nothing

    1 1 / 1 5 -> nothing 
    2 2 / 1 5 -> nothing
    3 3 / 1 5 -> nothing

123 / 1 3 -> ball

    1 1 / 1 3 -> nothing
    2 2 / 1 3 -> nothing
    3 3 / 1 3 -> ball

123 / 1 1 -> strike

    1 1 / 1 1 -> strike
    2 2 / 1 1 -> nothing
    3 3 / 1 1 -> nothing

Balls balls = new Balls(Arrays.asList(1,2,3));

balls.play(new Ball(1, 5)) -> nothing balls.play(new Ball(1, 3)) -> ball balls.play(new Ball(1, 1))
-> strike

NumberGenerator numberGenerator = new NumberGenerator();

actual = numberGenerator.createRandomNumber();



