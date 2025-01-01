package racing;

/**
 * 이동, 상태 (position, name) 에 대한 내용만 있는게 바람직한 도메인 설계
 */
public class Car {

    public static final int MOVE_THRESHOLD = 4;
    public static final String NAME_LENGTH_LIMIT_EXCEPTION_MESSAGE = "이름은 5글자를 초과할 수 없습니다.";
    public static final int NAME_THRESHOLD = 5;
    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }
}
