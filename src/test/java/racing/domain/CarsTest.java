package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("승리자 이름")
    void winners() {
        Cars cars = Cars.createCars(Arrays.asList("pobi", "crong", "honux"));

        cars.getCars().get(0).move(4);
        cars.getCars().get(1).move(4);

        assertThat(cars.findWinnerNames()).isEqualTo(Arrays.asList("pobi", "crong"));
        assertThat(cars.findWinnerNames().contains("honux")).isFalse();
    }
}
