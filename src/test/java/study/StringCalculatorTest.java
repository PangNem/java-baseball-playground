package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {


  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2,10", "3 + 5 * 6 / 12,4"})
  void StringCalculator(String value, int expected) {
    // given
    String[] values = value.split(" ");
    int actual = Integer.parseInt(values[0]);

    // when
    actual = getCalculatedValue(values, actual);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  private int getCalculatedValue(String[] values, int actual) {
    for (int i = 1; i < values.length; i++) {
      String currentValue = values[i];
      if (isOperator(currentValue)) {
        int nextValue = Integer.parseInt(values[i+1]);
        actual = calculate(actual, currentValue, nextValue);
      }
    }

    return actual;
  }

  private int calculate(int actual, String currentValue, int nextValue) {
    if ("+".equals(currentValue)) {
      actual += nextValue;
    }
    if ("-".equals(currentValue)) {
      actual -= nextValue;
    }
    if ("*".equals(currentValue)) {
      actual *= nextValue;
    }
    if ("/".equals(currentValue)) {
      actual /= nextValue;
    }
    return actual;
  }

  private boolean isOperator(String value) {
    List<String> operators = Arrays.asList("+", "-", "*", "/");

    return operators.stream()
        .anyMatch(operator -> operator.equals(value));
  }

}
