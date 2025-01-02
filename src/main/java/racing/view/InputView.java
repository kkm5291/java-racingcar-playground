package racing.view;

public class InputView {

    public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String PROCESS_MESSAGE = "실행 결과";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printCountMessage() {
        System.out.println(COUNT_MESSAGE);
    }

    public static void printProcessMessage() {
        System.out.println(PROCESS_MESSAGE);
    }
}
