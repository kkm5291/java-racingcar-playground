package racing.domain;

import racing.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for(String name : names) {
            cars.add(Car.createCar(name));
        }

        return new Cars(cars);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        for(Car car : cars) {
            car.move(RandomUtils.createRandomValue());
        }
    }

    public List<String> findWinnerNames() {

        return cars.stream()
                .filter(car -> car.getPosition() == findMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
