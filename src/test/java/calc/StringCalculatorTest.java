package calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

    @Test
    void when_input_value_null_then_return_zero() {
        String rawString = null;
        int answer = StringCalculator.splitAndSum(rawString);
        assertThat(answer).isEqualTo(0);
    }

    @Test
    void when_input_value_empty_then_return_zero() {
        String rawString = "";
        int answer = StringCalculator.splitAndSum(rawString);
        assertThat(answer).isEqualTo(0);
    }

    @Test
    void only_one_number_then_return_itself() {
        String rawString = "1";
        int answer = StringCalculator.splitAndSum(rawString);
        assertThat(answer).isEqualTo(Integer.parseInt(rawString));
    }

    @Test
    void delimiter_is_comma_then_return_sum() {
        String rawString = "1,2,3";
        int answer = StringCalculator.splitAndSum(rawString);
        assertThat(answer).isEqualTo(6);
    }

    @Test
    void delimiter_is_colon_then_return_sum() {
        String rawString = "1:2:3";
        int answer = StringCalculator.splitAndSum(rawString);
        assertThat(answer).isEqualTo(6);
    }

    @Test
    void delimiter_mixed() {
        String rawString = "1,2:3";
        int answer = StringCalculator.splitAndSum(rawString);
        assertThat(answer).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_delimiter() throws Exception {
        String rawString = "//;\n1;2;3";
        int answer = StringCalculator.splitAndSum(rawString);
        assertThat(answer).isEqualTo(6);
    }

    @Test
    public void negative_Numbers_raise_exception() throws Exception {
        String rawString = "-1:2:3";
        assertThatThrownBy(() -> StringCalculator.splitAndSum(rawString))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("양수만 가능합니다.");

    }
}
