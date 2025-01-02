package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {

    @Test
    @DisplayName("랜덤값은 9를 넘어가선 안됨")
    void randomValueLimit() throws Exception {
        int randomValue = RandomUtils.createRandomValue();

        assertThat(randomValue).isLessThanOrEqualTo(9);
    }
}
