package racing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputUtilsTest {

    private final InputStream standardIn = System.in;
    private String nameInput;

    @BeforeEach
    void setUp() {
        nameInput = "gong, kyung, jung";
    }

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
    }

    @Test
    @DisplayName("InputUtils 내부 문자 split은 , 를 기준으로 한다.")
    void splitName() throws Exception {
        // given
        System.setIn(new ByteArrayInputStream(nameInput.getBytes()));

        List<String> names = InputUtils.inputCarNames();
        assertThat(names.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("InputUtils split 후 내부 값 검증")
    void 내부값_검증() throws Exception {
        //given
        System.setIn(new ByteArrayInputStream(nameInput.getBytes()));

        List<String> names = InputUtils.inputCarNames();
        assertThat(names.contains("gong")).isTrue();
        assertThat(names.contains("kyung")).isTrue();
        assertThat(names.contains("jung")).isTrue();
    }
}