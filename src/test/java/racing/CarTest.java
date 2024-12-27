package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static Car car;

    @BeforeEach
    void setUp() {
        car = Car.createCar("name");
    }

    @Test
    @DisplayName("randomValue가 4 이하일 경우 position 유지")
    void stayCar() {
        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("randomValue가 4 이상일 경우 position 증가")
    void moveCar() {
        car.move(4);
        assertThat(car.getPosition()).isGreaterThan(0);
    }
}
