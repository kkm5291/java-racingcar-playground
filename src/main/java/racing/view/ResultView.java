package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.Collections;
import java.util.List;

public class ResultView {

    private static final String PROCESS_IMAGE = "-";
    public static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void processView(Cars cars) {
        for(Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + parsePositionToImage(car.getPosition()));
        }
        System.out.println();
    }

    public static String parsePositionToImage(int position) {
        return String.join(PROCESS_IMAGE, Collections.nCopies(position+1, ""));
    }

    public static void announceWinners(List<String> winnerNames) {
        String result = String.join(", ", winnerNames);

        System.out.println(result + WINNER_MESSAGE);
    }
}
