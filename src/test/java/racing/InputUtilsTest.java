package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputUtilsTest {

    @Test
    @DisplayName("문자 구분은 , 로 한다")
    void splitName() {
        String nameInput = "gong, kyung, jung";
        String[] names = nameInput.split("[,]");

        assertThat(names.length).isEqualTo(3);
    }

    @Test
    @DisplayName("이름은 5글자 이하")
    void nameValidation() {
        boolean valid = InputUtils.nameValidation("Steve");
        assertThat(valid).isTrue();
    }

    @Test
    @DisplayName("5글자 초과 시 예외 발생")
    void nameValidation_ex() {
        assertThatThrownBy(() -> InputUtils.nameValidation("SteveSteveSteveSteveSteve")).isInstanceOf(RuntimeException.class);
    }
}
