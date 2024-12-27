package racing;

import java.util.Scanner;

public class InputUtils {

    public static final int NAME_LIMIT_LENGTH = 5;
    public static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 5글자 이하만 가능합니다";

    public static final Scanner sc = new Scanner(System.in);

    public static boolean nameValidation(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new RuntimeException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static String inputValue() {
        return sc.nextLine();
    }
}
