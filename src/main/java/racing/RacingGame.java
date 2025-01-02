package racing;

import racing.domain.Cars;
import racing.utils.InputUtils;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGame {

    public static int CAR_COUNT;
    public static int REPEAT_COUNT;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        InputView.printStartMessage();

        Cars cars = Cars.createCars(InputUtils.inputCarNames());
        CAR_COUNT = cars.size();

        InputView.printCountMessage();
        REPEAT_COUNT = InputUtils.inputCount();

        InputView.printProcessMessage();
        ResultView.processView(cars);

        for(int i=0; i<REPEAT_COUNT; i++) {
            cars.moveAll();
            ResultView.processView(cars);
        }

        ResultView.announceWinners(cars.findWinnerNames());
    }
}
