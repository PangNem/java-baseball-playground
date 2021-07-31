package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallTest {

    private final BaseBall baseBall = new BaseBall();

    @Test
    @DisplayName("1~9 랜덤 숫자를 3개를 생성한다.")
    void getRandomNumberList() {
        // given
        List<Integer> expectedNumberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // when
        List<Integer> actual = baseBall.getRandomNumberList();

        // then
        assertThat(actual.size()).isEqualTo(3);
        actual.forEach(number -> assertThat(expectedNumberList.contains(number)).isTrue());
    }

    @Test
    @DisplayName("입력받은 숫자를 파싱한다.")
    void getInputNumberList() {
        // given
        String values = "123";
        List<Integer> expectedList = Arrays.asList(1, 2, 3);

        // when
        List<Integer> actual = baseBall.getParsedInputNumberList(values);

        // then
        assertThat(actual).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("입력받은 숫자와 정답 숫자 비교하여 결과 반환")
    void getResult() {
        // given
        List<Integer> userInputList = Arrays.asList(3, 1, 4);
        List<Integer> randomNumberList = Arrays.asList(1, 5, 4);

        // when
        int isInRandomNumberCount = baseBall
            .getIsInRandomNumberCount(randomNumberList, userInputList);
        int strikeCount = baseBall.getStrikeCount(randomNumberList, userInputList);

        // then
        assertThat(isInRandomNumberCount).isEqualTo(2);
        assertThat(strikeCount).isEqualTo(1);
    }
}
