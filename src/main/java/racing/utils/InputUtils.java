package racing.utils;

import java.util.*;
import java.util.stream.Collectors;

public class InputUtils {

    public static final int NAME_LIMIT_LENGTH = 5;
    public static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 5글자 이하만 가능합니다";

    public static List<String> inputCarNames() {
        String names = inputValue();
        return splitName(names);
    }

    public static int inputCount() {
        String count = inputValue();
        return Integer.parseInt(count);
    }

    private static String inputValue() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static List<String> splitName(String names) {
        String[] split = names.split("[,]");
        return Arrays.stream(split)
                .map(String::trim)
                .peek(InputUtils::nameValidation)
                .collect(Collectors.toList());
    }

    private static void nameValidation(String name) {
        if (name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
