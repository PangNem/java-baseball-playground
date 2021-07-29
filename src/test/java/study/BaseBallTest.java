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
}
