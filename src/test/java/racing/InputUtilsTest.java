package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputUtilsTest {

    @Test
    @DisplayName("문자 구분은 , 로 한다")
    void splitName() {
        String nameInput = "gong, kyung, jung";
        String[] names = nameInput.split("[,]");

        assertThat(names.length).isEqualTo(3);
    }
}
