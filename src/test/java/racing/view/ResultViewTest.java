package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {

    @Test
    @DisplayName("position to dash-image")
    void parsePosition() {
        assertThat(ResultView.parsePositionToImage(3)).isEqualTo("---");
        assertThat(ResultView.parsePositionToImage(5)).isEqualTo("-----");
        assertThat(ResultView.parsePositionToImage(1)).isEqualTo("-");
    }
}