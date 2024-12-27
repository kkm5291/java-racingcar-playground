package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("이름은 5글자 이하")
    void nameValidation() {
        boolean valid = ValidationUtils.nameValidation("Steve");
        assertThat(valid).isTrue();
    }

    @Test
    @DisplayName("5글자 초과 시 예외 발생")
    void nameValidation_ex() {
        assertThatThrownBy(() -> ValidationUtils.nameValidation("SteveSteveSteveSteveSteve")).isInstanceOf(RuntimeException.class);
    }


}
