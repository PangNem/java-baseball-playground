package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
 private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("사이즈를 확인한다.")
  void size() {
    int actual = numbers.size();
    assertThat(actual).isEqualTo(3);
  }

  @Test
  @DisplayName("값이 존재하는지 확인한다.")
  void contains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  @DisplayName("값이 존재하는지 확인 - parameterizedTest")
  void containsWithParameterizedTest(int number) {
    assertThat(number).isInstanceOf(Integer.class);

    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiterString = ":")
  @DisplayName("값이 존재하는지 확인 - csv source")
  void containsWithCsvSource(int number, boolean isExist) {
    assertThat(number).isInstanceOf(Integer.class);
    assertThat(isExist).isInstanceOf(Boolean.class);

    boolean actual = numbers.contains(number);
    assertThat(actual).isEqualTo(isExist);
  }
}
