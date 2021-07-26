package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

        String[] actual1 = "1,2".split(",");
        assertThat(actual1).containsExactly("1", "2");

        String[] actual2 = "1".split(",");
        assertThat(actual2).contains("1");
    }

    @Test
    void substring() {
        //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.

        String actual ="(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt()에서 문자열의 길이를 초과한 값을 넘길 때 예외를 발생시킨다.")
    void charAt() {
        // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        //JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.


        assertThatThrownBy(() -> "abc".charAt(6))
            .isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> "abc".charAt(6));
    }
}
